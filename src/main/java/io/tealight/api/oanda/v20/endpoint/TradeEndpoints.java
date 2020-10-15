package io.tealight.api.oanda.v20.endpoint;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.def.trade.Trade;
import io.tealight.api.oanda.v20.def.trade.TradeResponse;
import io.tealight.api.oanda.v20.def.trade.TradeStateFilter;
import io.tealight.api.oanda.v20.def.trade.TradesResponse;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;
import io.tealight.api.oanda.v20.internal.EndpointRequest;
import io.tealight.api.oanda.v20.internal.ResponseLinkFollowerFunction;

/**
 * Trade endpoints
 * 
 * https://developer.oanda.com/rest-live-v20/trade-ep/
 *
 * @author Fredy Yanardi
 */
public class TradeEndpoints {

    private static final String TRADES = "/v3/accounts/%s/trades";
    private static final String OPEN_TRADES = "/v3/accounts/%s/openTrades";
    private static final String TRADE = "/v3/accounts/%s/trades/%s";

    private final FxTradeContext fxTradeContext;

    public TradeEndpoints(FxTradeContext fxTradeContext) {
        this.fxTradeContext = fxTradeContext;
    }

    /**
     * Get a list of Trades for an Account
     *
     * @param accountId Account Identifier [required]
     * @param ids List of Trade IDs to retrieve.
     * @param state The state to filter the requested Trades by. [default=OPEN]
     * @param instrument The instrument to filter the requested Trades by.
     * @param count The maximum number of Trades to return. [default=50, maximum=500]
     * @param beforeID The maximum Trade ID to return. If not provided the most recent Trades in the
     *      Account are returned.
     * @return list of Trades for an Account that match the specified criteria
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public TradesResponse getTrades(String accountId, List<String> ids, TradeStateFilter state,
            String instrument, Integer count, String beforeID)
                    throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(TRADES, accountId);
        Map<String, String> queries = new LinkedHashMap<>();
        if (ids != null) {
            queries.put("ids", ids.stream().collect(Collectors.joining(",")));
        }
        if (state != null) {
            queries.put("state", state.toString());
        }
        if (instrument != null) {
            queries.put("instrument", instrument);
        }
        if (count != null) {
            queries.put("count", count.toString());
        }
        if (beforeID != null) {
            queries.put("beforeID", beforeID);
        }

        // If the response contains a 'Link' header, try to follow that
        List<TradesResponse> tradesResponses = new LinkedList<TradesResponse>();

        ResponseLinkFollowerFunction<TradesResponse> headerFunction =
                new ResponseLinkFollowerFunction<>(fxTradeContext, tradesResponses, TradesResponse.class);

        EndpointRequest<TradesResponse> endpointRequest =
                new EndpointRequest.Builder<TradesResponse>(TradesResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(!queries.isEmpty() ? queries : null)
                    .headerFunction(headerFunction)
                    .build();

        TradesResponse tradesResponse = fxTradeContext.requestEndpoint(endpoint, endpointRequest);

        tradesResponses.add(0, tradesResponse);

        BiConsumer<TradesResponse, TradesResponse> accumulatorCombiner =
                new BiConsumer<TradesResponse, TradesResponse>() {

            @Override
            public void accept(TradesResponse t, TradesResponse u) {
                if (t.getLastTransactionID() == null) {
                    t.setLastTransactionID(u.getLastTransactionID());
                }
                Trade[] trades0 = t.getTrades();
                Trade[] trades1 = u.getTrades();
                if (trades0 == null) {
                    t.setTrades(Arrays.copyOf(trades1, trades1.length));
                }
                else {
                    if (trades1 != null) {
                        int totalTrades = trades0.length + trades1.length;
                        Trade[] trades = Arrays.copyOf(trades0, totalTrades);
                        System.arraycopy(trades1, 0, trades, trades0.length, trades1.length);
                        t.setTrades(trades);
                    }
                }
            }
        };

        return tradesResponses.stream().collect(TradesResponse::new, accumulatorCombiner,
                accumulatorCombiner);
    }

    /**
     * Get the list of open Trades for an Account
     *
     * @param accountId Account Identifier [required]
     * @return list of open Trades for an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public TradesResponse getOpenTrades(String accountId) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(OPEN_TRADES, accountId);

        return fxTradeContext.requestEndpoint(endpoint, TradesResponse.class);
    }

    /**
     * Get the details of a specific Trade in an Account
     *
     * @param accountId Account Identifier [required]
     * @param tradeSpecifier Specifier for the Trade [required]
     * @return the details of a specific Trade in an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public TradeResponse getTrade(String accountId, String tradeSpecifier)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(tradeSpecifier);

        String endpoint = String.format(TRADE, accountId, tradeSpecifier);

        return fxTradeContext.requestEndpoint(endpoint, TradeResponse.class);
    }
}
