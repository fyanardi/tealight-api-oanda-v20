package io.tealight.api.oanda.v20.sample;

import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;

import io.tealight.api.oanda.v20.FxTradeType;
import io.tealight.api.oanda.v20.OandaV20Api;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.account.AccountProperties;
import io.tealight.api.oanda.v20.endpoint.AccountEndpoints;
import io.tealight.api.oanda.v20.endpoint.response.account.AccountChangesResponse;
import io.tealight.api.oanda.v20.endpoint.response.account.AccountInstrumentsResponse;
import io.tealight.api.oanda.v20.endpoint.response.account.AccountResponse;
import io.tealight.api.oanda.v20.endpoint.response.account.AccountSummaryResponse;
import io.tealight.api.oanda.v20.endpoint.response.account.AccountsResponse;
import io.tealight.api.oanda.v20.exception.FxTradeException;

public class AccountSample {

    private static final FxTradeType FX_TRADE_TYPE = FxTradeType.FX_TRADE_PRACTICE;

    public static void main(String[] args) {
        String oandaToken = System.getenv("OANDA_TOKEN");

        Gson gson = PrimitiveGsonAdapters.newGsonBuilder().create();
        OandaV20Api oandaV20Api = new OandaV20Api(FX_TRADE_TYPE, oandaToken);
        AccountEndpoints accountEndpoints = oandaV20Api.getAccountEndpoints();

        try {
            AccountsResponse accounts = accountEndpoints.getAccounts();
            System.out.println(gson.toJson(accounts));
            for (AccountProperties accountProperty : accounts.getAccounts()) {
                String accountId = accountProperty.getId();

                AccountResponse account = accountEndpoints.getAccount(accountId);
                System.out.println(gson.toJson(account));

                AccountSummaryResponse accountSummary =
                        accountEndpoints.getAccountSummary(accountId);
                System.out.println("===== Account summary =====");
                System.out.println(gson.toJson(accountSummary));
                AccountInstrumentsResponse instruments =
                        accountEndpoints.getAccountInstrument(accountProperty.getId(), 
                                Arrays.asList("EUR_USD"));
                System.out.println("instruments: " + gson.toJson(instruments));

                // This will change your account alias - uncomment with care!!
                /* AccountConfigurationRequest accountConfigurationRequest =
                        new AccountConfigurationRequest();
                accountConfigurationRequest.setAlias("Practice");
                AccountConfigurationResponse accountConfigurationResponse = 
                         accountEndpoints.setAccountConfiguration(accountProperty.getId(),
                                 accountConfigurationRequest);
                System.out.println("setAccountConfiguration(): " +
                         gson.toJson(accountConfigurationResponse)); */

                AccountChangesResponse accountStateAndChanges =
                        accountEndpoints.getAccountChanges(accountProperty.getId(), "539");
                System.out.println("Account changes: " + gson.toJson(accountStateAndChanges));
                break;
            }
        } catch (FxTradeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
