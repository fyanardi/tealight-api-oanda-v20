package io.tealight.api.oanda.v20.endpoint;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.def.instrument.CandlestickResponse;
import io.tealight.api.oanda.v20.def.instrument.OrderBook;
import io.tealight.api.oanda.v20.def.instrument.PositionBook;
import io.tealight.api.oanda.v20.endpoint.query.instrument.CandlesQuery;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;
import io.tealight.api.oanda.v20.internal.EndpointRequest;

/**
 * Instrument endpoints
 * 
 * https://developer.oanda.com/rest-live-v20/instrument-ep/
 *
 * @author Fredy Yanardi
 *
 */
public class InstrumentEndpoints {

    private static final String CANDLES = "/v3/instruments/%s/candles";
    private static final String ORDER_BOOK = "/v3/instruments/%s/orderBook";
    private static final String POSITION_BOOK = "/v3/instruments/%s/positionBook";

    private final FxTradeContext fxTradeContext;

    public InstrumentEndpoints(FxTradeContext fxTradeContext) {
        this.fxTradeContext = fxTradeContext;
    }

    /**
     * Fetch candlestick data for an instrument.
     * 
     * @param instrument instrument whose candlestick data to be fetched
     * @param candlesQuery fetch candlestick data query
     * @return candlestick response for the specified instrument according to the request data
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public CandlestickResponse getCandles(String instrument, CandlesQuery candlesQuery)
            throws FxTradeException, IOException {
        Objects.requireNonNull(instrument);

        String endpoint = String.format(CANDLES, instrument);

        Map<String, String> queries = FxTradeEndpointsUtils.queryFromQueryObject(candlesQuery);

        EndpointRequest<CandlestickResponse> endpointRequest =
                new EndpointRequest.Builder<CandlestickResponse>(CandlestickResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    public OrderBook getOrderBook(String instrument, ZonedDateTime time)
            throws FxTradeException, IOException {
        Objects.requireNonNull(instrument);

        Map<String, String> queries = null;
        if (time != null) {
            queries = new HashMap<>();
            queries.put("time", FxTradeEndpointsUtils.toUtcZonedDateTime(time).toString());
        }

        String endpoint = String.format(ORDER_BOOK, instrument);

        EndpointRequest<OrderBook> endpointRequest =
                new EndpointRequest.Builder<OrderBook>(OrderBook.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    public PositionBook getPositionBook(String instrument, ZonedDateTime time)
            throws FxTradeException, IOException {
        Objects.requireNonNull(instrument);

        Map<String, String> queries = null;
        if (time != null) {
            queries = new HashMap<>();
            queries.put("time", FxTradeEndpointsUtils.toUtcZonedDateTime(time).toString());
        }

        String endpoint = String.format(POSITION_BOOK, instrument);

        EndpointRequest<PositionBook> endpointRequest =
                new EndpointRequest.Builder<PositionBook>(PositionBook.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }
}
