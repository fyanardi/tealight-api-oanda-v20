package io.tealight.api.oanda.v20.sample;

import java.io.IOException;

import com.google.gson.Gson;

import io.tealight.api.oanda.v20.FxTradeType;
import io.tealight.api.oanda.v20.OandaV20Api;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.account.AccountsResponse;
import io.tealight.api.oanda.v20.def.position.PositionCloseRequest;
import io.tealight.api.oanda.v20.def.position.PositionCloseResponse;
import io.tealight.api.oanda.v20.def.position.PositionsResponse;
import io.tealight.api.oanda.v20.endpoint.AccountEndpoints;
import io.tealight.api.oanda.v20.endpoint.PositionEndpoints;
import io.tealight.api.oanda.v20.exception.FxTradeException;

/**
 * Sample code on how to invoke PositionEndpoints APIs
 *
 * @author Fredy Yanardi
 *
 */
public class PositionSample {

    private static final FxTradeType FX_TRADE_TYPE = FxTradeType.FX_TRADE_PRACTICE;

    public static void main(String[] args) {
        String oandaToken = System.getenv("OANDA_TOKEN");

        Gson gson = PrimitiveGsonAdapters.newGsonBuilder().setPrettyPrinting().create();

        OandaV20Api oandaV20Api = new OandaV20Api(FX_TRADE_TYPE, oandaToken);
        PositionEndpoints positionEndpoints = oandaV20Api.getPositionEndpoints();

        AccountEndpoints accountEndpoints = oandaV20Api.getAccountEndpoints();

        try {
            AccountsResponse accounts = accountEndpoints.getAccounts();
            if (accounts.getAccounts().length == 0) {
                System.err.println("No account information available");
                return;
            }

            String accountId = accounts.getAccounts()[0].getId();

            System.out.println("+++++ Get all positions +++++");
            PositionsResponse allPositions = positionEndpoints.getPositions(accountId);
            System.out.println(gson.toJson(allPositions));
            System.out.println();

            System.out.println("+++++ Get open positions +++++");
            PositionsResponse openPositions = positionEndpoints.getOpenPositions(accountId);
            System.out.println(gson.toJson(openPositions));
            System.out.println();

            System.out.println("+++++ Get positions for EUR/USD +++++");
            PositionsResponse euPositions = positionEndpoints.getPositionsByInstrument(accountId,
                    "EUR_USD");
            System.out.println(gson.toJson(euPositions));
            System.out.println();

            System.out.println("+++++ Close 100 units of EUR/USD short +++++");
            PositionCloseRequest positionCloseRequest = new PositionCloseRequest();
            positionCloseRequest.setLongUnits("NONE");
            positionCloseRequest.setShortUnits("100");

            PositionCloseResponse positionCloseResponse = positionEndpoints.closePosition(accountId, "EUR_USD",
                    positionCloseRequest);
            System.out.println(gson.toJson(positionCloseResponse));
            System.out.println();
        }
        catch (FxTradeException e) {
            e.printStackTrace();
            System.out.println("Error response code: " + e.getHttpResponseCode() + " message: " +
                    gson.toJson(e.getErrorResponse()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
