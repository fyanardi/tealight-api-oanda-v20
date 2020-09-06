package io.tealight.api.oanda.v20.endpoint.response.account;

import java.util.List;

import io.tealight.api.oanda.v20.def.account.AccountProperties;

public class AccountsResponse {

    private List<AccountProperties> accounts;

    public List<AccountProperties> getAccounts() {
        return accounts;
    }

}
