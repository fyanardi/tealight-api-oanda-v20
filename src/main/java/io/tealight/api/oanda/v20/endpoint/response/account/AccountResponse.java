package io.tealight.api.oanda.v20.endpoint.response.account;

import io.tealight.api.oanda.v20.def.account.Account;

public class AccountResponse {
    private Account account;
    private String lastTransactionID;

    public Account getAccount() {
        return account;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

}
