package io.tealight.api.oanda.v20.sample;

import java.io.IOException;

import com.google.gson.Gson;

import io.tealight.api.oanda.v20.FxTradeType;
import io.tealight.api.oanda.v20.OandaV20Api;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.account.AccountsResponse;
import io.tealight.api.oanda.v20.def.trade.Trade;
import io.tealight.api.oanda.v20.def.trade.TradeResponse;
import io.tealight.api.oanda.v20.def.trade.TradeStateFilter;
import io.tealight.api.oanda.v20.def.trade.TradesResponse;
import io.tealight.api.oanda.v20.endpoint.AccountEndpoints;
import io.tealight.api.oanda.v20.endpoint.TradeEndpoints;
import io.tealight.api.oanda.v20.exception.FxTradeException;

/**
 * Sample code on how to invoke TransactionEndpoints APIs
 *
 * @author Fredy Yanardi
 *
 */
public class TradeSample {

    private static final FxTradeType FX_TRADE_TYPE = FxTradeType.FX_TRADE_PRACTICE;

    public static void main(String[] args) {
        String oandaToken = System.getenv("OANDA_TOKEN");

        Gson gson = PrimitiveGsonAdapters.newGsonBuilder()./* setPrettyPrinting(). */create();

        OandaV20Api oandaV20Api = new OandaV20Api(FX_TRADE_TYPE, oandaToken);
        TradeEndpoints tradeEndpoints = oandaV20Api.getTradeEndpoints();

        AccountEndpoints accountEndpoints = oandaV20Api.getAccountEndpoints();

        try {
            AccountsResponse accounts = accountEndpoints.getAccounts();
            if (accounts.getAccounts().length == 0) {
                System.err.println("No account information available");
                return;
            }

            String accountId = accounts.getAccounts()[0].getId();
            String tradeId = null;

            System.out.println("+++++ Get all closed trades for this account +++++");
            TradesResponse closedTrades = tradeEndpoints.getTrades(accountId, null,
                    TradeStateFilter.CLOSED, null, null, null);
            // System.out.println(tradesResponse.getTrades().length);
            System.out.println("lastTransactionID=" + closedTrades.getLastTransactionID() +
                    " total=" + closedTrades.getTrades().length);
            for (Trade trade : closedTrades.getTrades()) {
                if (tradeId == null) {
                    tradeId = trade.getId();
                }
                System.out.println(gson.toJson(trade));
            }

            System.out.println();

            System.out.println("+++++ Get all open trades for this account +++++");
            TradesResponse openTrades = tradeEndpoints.getOpenTrades(accountId);
            // System.out.println(tradesResponse.getTrades().length);
            System.out.println("lastTransactionID=" + openTrades.getLastTransactionID() +
                    " total=" + openTrades.getTrades().length);
            for (Trade trade : openTrades.getTrades()) {
                System.out.println(gson.toJson(trade));
            }

            System.out.println();

            System.out.println("+++++ Get a specific trade for this account (tradeId=" + tradeId +
                    ") +++++");
            TradeResponse trade = tradeEndpoints.getTrade(accountId, tradeId);
            System.out.println(gson.toJson(trade));
        }
        catch (FxTradeException e) {
            e.printStackTrace();
            System.out.println("Error response code: " + e.getHttpResponseCode() + " message: '" +
                    new Gson().toJson(e.getErrorResponse()) + "'");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
