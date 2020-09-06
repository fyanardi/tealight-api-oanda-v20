package io.tealight.api.oanda.v20.endpoint.response.account;

import io.tealight.api.oanda.v20.def.transaction.ClientConfigureTransaction;

public class AccountConfigurationResponse {

    private ClientConfigureTransaction clientConfigureTransaction;
    private String lastTransactionID;

    public ClientConfigureTransaction getClientConfigureTransaction() {
        return clientConfigureTransaction;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

}
