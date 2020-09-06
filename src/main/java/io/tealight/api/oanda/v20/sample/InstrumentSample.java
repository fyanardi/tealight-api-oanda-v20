package io.tealight.api.oanda.v20.sample;

import java.io.IOException;
import java.time.ZonedDateTime;

import com.google.gson.Gson;

import io.tealight.api.oanda.v20.FxTradeType;
import io.tealight.api.oanda.v20.OandaV20Api;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.instrument.CandlestickGranularity;
import io.tealight.api.oanda.v20.def.instrument.CandlestickResponse;
import io.tealight.api.oanda.v20.def.instrument.OrderBook;
import io.tealight.api.oanda.v20.def.instrument.PositionBook;
import io.tealight.api.oanda.v20.endpoint.InstrumentEndpoints;
import io.tealight.api.oanda.v20.endpoint.request.instrument.CandlesRequest;
import io.tealight.api.oanda.v20.exception.FxTradeException;

public class InstrumentSample {

    private static final FxTradeType FX_TRADE_TYPE = FxTradeType.FX_TRADE_PRACTICE;

    public static void main(String[] args) {
        String oandaToken = System.getenv("OANDA_TOKEN");

        Gson gson = PrimitiveGsonAdapters.newGsonBuilder().setPrettyPrinting().create();

        OandaV20Api oandaV20Api = new OandaV20Api(FX_TRADE_TYPE, oandaToken);
        InstrumentEndpoints instrumentEndpoints = oandaV20Api.getInstrumentEndpoints();

        CandlesRequest candlesRequest = new CandlesRequest();
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

        try {
            OrderBook orderBook = instrumentEndpoints.getOrderBook("USD_JPY", 
                    ZonedDateTime.parse("2020-08-31T04:00:00Z"));
            System.out.println(gson.toJson(orderBook));
        } catch (FxTradeException | IOException e) {
            e.printStackTrace();
        }

        try {
            PositionBook positionBook = instrumentEndpoints.getPositionBook("EUR_USD",  null);
            System.out.println(gson.toJson(positionBook));
        } catch (FxTradeException | IOException e) {
            e.printStackTrace();
        }
    }

}
