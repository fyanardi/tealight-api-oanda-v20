package io.tealight.api.oanda.v20.sample;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.Map.Entry;

import com.google.gson.Gson;

import io.tealight.api.oanda.v20.FxTradeType;
import io.tealight.api.oanda.v20.OandaV20Api;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.transaction.TransactionFilter;
import io.tealight.api.oanda.v20.def.transaction.TransactionPagesResponse;
import io.tealight.api.oanda.v20.def.transaction.TransactionResponse;
import io.tealight.api.oanda.v20.def.transaction.TransactionsResponse;
import io.tealight.api.oanda.v20.endpoint.AccountEndpoints;
import io.tealight.api.oanda.v20.endpoint.TransactionEndpoints;
import io.tealight.api.oanda.v20.endpoint.response.account.AccountsResponse;
import io.tealight.api.oanda.v20.exception.FxTradeException;

/**
 * Sample code on how to invoke TransactionEndpoints APIs
 *
 * @author Fredy Yanardi
 *
 */
public class TransactionSample {

    private static final FxTradeType FX_TRADE_TYPE = FxTradeType.FX_TRADE_PRACTICE;

    public static void main(String[] args) {
        String oandaToken = System.getenv("OANDA_TOKEN");

        Gson gson = PrimitiveGsonAdapters.newGsonBuilder().setPrettyPrinting().create();

        OandaV20Api oandaV20Api = new OandaV20Api(FX_TRADE_TYPE, oandaToken);
        TransactionEndpoints transactionEndpoints = oandaV20Api.getTransactionEndpoints();

        AccountEndpoints accountEndpoints = oandaV20Api.getAccountEndpoints();

        try {
            AccountsResponse accounts = accountEndpoints.getAccounts();
            if (accounts.getAccounts().size() == 0) {
                System.err.println("No account information available");
                return;
            }

            String accountId = accounts.getAccounts().get(0).getId();

            // Find all filled orders from 2 months ago
            System.out.println("+++++ Get all filled orders from 2 months ago +++++");
            ZonedDateTime fromTime = ZonedDateTime.now().minus(2, ChronoUnit.MONTHS);
            TransactionPagesResponse transactionPagesResponse =
                    transactionEndpoints.getTransactions(accountId, fromTime, null, null,
                            EnumSet.of(TransactionFilter.ORDER_FILL));
            System.out.println(gson.toJson(transactionPagesResponse));

            String sinceId = null;

            // Get the details of every filled order transactions from 2 months ago
            for (String page : transactionPagesResponse.getPages()) {
                Entry<String, String> idRange = TransactionEndpoints.getIdRangeFromPageUrl(page);
                String from = idRange.getKey();
                String to = idRange.getValue();
                System.out.println("+++++ Get all filled orders from id=" + from + " to id=" + to +
                        " +++++");
                if (sinceId == null) {
                    sinceId = to;
                }
                System.out.println("* page=[" + page + "] from=" + from + " to=" + to + " *");
                TransactionsResponse transactionResponse =
                        transactionEndpoints.getTransactionsInRange(accountId, from, to,
                                EnumSet.of(TransactionFilter.ORDER_FILL));
                System.out.println(gson.toJson(transactionResponse));
            }

            if (sinceId != null) {
                System.out.println("+++++ Get Specific Transaction (id=" + sinceId + ") +++++");
                TransactionResponse transactionResponse =
                        transactionEndpoints.getTransaction(accountId, sinceId);
                System.out.println(gson.toJson(transactionResponse));

                System.out.println("+++++ Get Order Cancel Transaction Since id=" + sinceId + " +++++");
                TransactionsResponse transactionsResponse =
                        transactionEndpoints.getTransactionsSinceId(accountId, sinceId,
                                EnumSet.of(TransactionFilter.ORDER_CANCEL));
                System.out.println(gson.toJson(transactionsResponse));
            }
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
