// This Java source file was generated on 2020-10-03 10:25:48 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import io.tealight.api.oanda.v20.def.transaction.ClientConfigureTransaction;

public class AccountConfigurationResponse {
    private ClientConfigureTransaction clientConfigureTransaction;
    private String lastTransactionID;

    public ClientConfigureTransaction getClientConfigureTransaction() {
        return clientConfigureTransaction;
    }

    public void setClientConfigureTransaction(ClientConfigureTransaction clientConfigureTransaction) {
        this.clientConfigureTransaction = clientConfigureTransaction;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
