// This Java source file was generated on 2020-10-03 10:25:47 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import io.tealight.api.oanda.v20.def.transaction.ClientConfigureRejectTransaction;

public class AccountConfigurationRejectResponse {
    private ClientConfigureRejectTransaction clientConfigureRejectTransaction;
    private String lastTransactionID;
    private String errorCode;
    private String errorMessage;

    public ClientConfigureRejectTransaction getClientConfigureRejectTransaction() {
        return clientConfigureRejectTransaction;
    }

    public void setClientConfigureRejectTransaction(ClientConfigureRejectTransaction clientConfigureRejectTransaction) {
        this.clientConfigureRejectTransaction = clientConfigureRejectTransaction;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
