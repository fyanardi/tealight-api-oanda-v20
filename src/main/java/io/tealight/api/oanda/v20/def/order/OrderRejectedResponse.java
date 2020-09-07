// This Java source file was generated on 2020-09-07 14:35:56 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.Transaction;

public class OrderRejectedResponse {
    private Transaction orderRejectTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;
    private String errorCode;
    private String errorMessage;

    public Transaction getOrderRejectTransaction() {
        return orderRejectTransaction;
    }

    public void setOrderRejectTransaction(Transaction orderRejectTransaction) {
        this.orderRejectTransaction = orderRejectTransaction;
    }

    public String[] getRelatedTransactionIDs() {
        return relatedTransactionIDs;
    }

    public void setRelatedTransactionIDs(String[] relatedTransactionIDs) {
        this.relatedTransactionIDs = relatedTransactionIDs;
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
