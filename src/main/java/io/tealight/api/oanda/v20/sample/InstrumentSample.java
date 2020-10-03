package io.tealight.api.oanda.v20.sample;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;

import io.tealight.api.oanda.v20.FxTradeType;
import io.tealight.api.oanda.v20.OandaV20Api;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.instrument.CandlestickGranularity;
import io.tealight.api.oanda.v20.def.instrument.CandlestickResponse;
import io.tealight.api.oanda.v20.def.instrument.OrderBook;
import io.tealight.api.oanda.v20.def.instrument.PositionBook;
import io.tealight.api.oanda.v20.endpoint.InstrumentEndpoints;
import io.tealight.api.oanda.v20.endpoint.query.instrument.CandlesQuery;
import io.tealight.api.oanda.v20.exception.FxTradeException;

public class InstrumentSample {

    private static final FxTradeType FX_TRADE_TYPE = FxTradeType.FX_TRADE_PRACTICE;

    public static void main(String[] args) {
        String oandaToken = System.getenv("OANDA_TOKEN");

        Gson gson = PrimitiveGsonAdapters.newGsonBuilder().setPrettyPrinting().create();

        OandaV20Api oandaV20Api = new OandaV20Api(FX_TRADE_TYPE, oandaToken);
        InstrumentEndpoints instrumentEndpoints = oandaV20Api.getInstrumentEndpoints();

        ZonedDateTime to = ZonedDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        System.out.println("+++++ Candles (Mid) n=2 to=" + to + " +++++");
        CandlesQuery candlesRequest = new CandlesQuery();
        candlesRequest.setPrice("M");
        candlesRequest.setGranularity(CandlestickGranularity.M15);
        candlesRequest.setCount(2);
        candlesRequest.setTo(to);

        try {
            CandlestickResponse candlestickResponse = instrumentEndpoints.getCandles("EUR_USD",
                    candlesRequest);
            System.out.println(gson.toJson(candlestickResponse));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("+++++ Candles (Mid) n=5 +++++");
        candlesRequest = new CandlesQuery();
        candlesRequest.setPrice("M");
        candlesRequest.setGranularity(CandlestickGranularity.H4);
        candlesRequest.setCount(5);
        try {
            CandlestickResponse candlestickResponse = instrumentEndpoints.getCandles("EUR_USD",
                    candlesRequest);
            System.out.println(gson.toJson(candlestickResponse));
            
        } catch (FxTradeException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("+++++ Order Book (USD/JPY) +++++");
        try {
            OrderBook orderBook = instrumentEndpoints.getOrderBook("USD_JPY", 
                    ZonedDateTime.parse("2020-08-31T04:00:00Z"));
            System.out.println(gson.toJson(orderBook));
        } catch (FxTradeException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("+++++ Position Book (EUR/USD) +++++");
        try {
            PositionBook positionBook = instrumentEndpoints.getPositionBook("EUR_USD",  null);
            System.out.println(gson.toJson(positionBook));
        } catch (FxTradeException | IOException e) {
            e.printStackTrace();
        }
    }

}
