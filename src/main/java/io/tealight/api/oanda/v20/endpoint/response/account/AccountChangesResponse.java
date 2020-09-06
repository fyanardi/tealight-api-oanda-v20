package io.tealight.api.oanda.v20.endpoint.response.account;

import io.tealight.api.oanda.v20.def.account.AccountChanges;
import io.tealight.api.oanda.v20.def.account.AccountChangesState;

public class AccountChangesResponse {

    private AccountChangesState state;
    private AccountChanges changes;
    private String lastTransactionID;

    public AccountChangesState getState() {
        return state;
    }

    public AccountChanges getChanges() {
        return changes;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

}
