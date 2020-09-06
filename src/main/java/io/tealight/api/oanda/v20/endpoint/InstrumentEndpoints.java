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
import io.tealight.api.oanda.v20.endpoint.request.instrument.CandlesRequest;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;

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
     * @param candlesRequest fetch candlestick data request
     * @return candlestick response for the specified instrument according to the request data
     * @throws FxTradeException
     * @throws IOException
     */
    public CandlestickResponse getCandles(String instrument, CandlesRequest candlesRequest)
            throws FxTradeException, IOException {
        Objects.requireNonNull(instrument);

        String endpoint = String.format(CANDLES, instrument);

        Map<String, String> query = FxTradeEndpointsUtils.queryFromRequestObject(candlesRequest);
        return fxTradeContext.requestEndpoint(endpoint, CandlestickResponse.class, HttpMethod.GET,
                query, null);
    }

    public OrderBook getOrderBook(String instrument, ZonedDateTime time)
            throws FxTradeException, IOException {
        Objects.requireNonNull(instrument);

        Map<String, String> query = null;
        if (time != null) {
            query = new HashMap<>();
            query.put("time", FxTradeEndpointsUtils.toUtcZonedDateTime(time).toString());
        }

        String endpoint = String.format(ORDER_BOOK, instrument);
        return fxTradeContext.requestEndpoint(endpoint, OrderBook.class, HttpMethod.GET, query, null);
    }

    public PositionBook getPositionBook(String instrument, ZonedDateTime time)
            throws FxTradeException, IOException {
        Objects.requireNonNull(instrument);

        Map<String, String> query = null;
        if (time != null) {
            query = new HashMap<>();
            query.put("time", FxTradeEndpointsUtils.toUtcZonedDateTime(time).toString());
        }

        String endpoint = String.format(POSITION_BOOK, instrument);
        return fxTradeContext.requestEndpoint(endpoint, PositionBook.class, HttpMethod.GET, query, null);
    }
}
