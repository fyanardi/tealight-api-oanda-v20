package io.tealight.api.oanda.v20.endpoint.response.account;

import io.tealight.api.oanda.v20.def.account.AccountSummary;

public class AccountSummaryResponse {

    private AccountSummary account;

    private String lastTransactionID;

    public AccountSummary getAccount() {
        return account;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

}
