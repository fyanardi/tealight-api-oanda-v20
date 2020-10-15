// This Java source file was generated on 2020-10-08 18:45:40 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.MarketOrderRejectTransaction;

public class TradeCloseRejectResponse {
    private MarketOrderRejectTransaction orderRejectTransaction;
    private String lastTransactionID;
    private String[] relatedTransactionIDs;
    private String errorCode;
    private String errorMessage;

    public MarketOrderRejectTransaction getOrderRejectTransaction() {
        return orderRejectTransaction;
    }

    public void setOrderRejectTransaction(MarketOrderRejectTransaction orderRejectTransaction) {
        this.orderRejectTransaction = orderRejectTransaction;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

    public String[] getRelatedTransactionIDs() {
        return relatedTransactionIDs;
    }

    public void setRelatedTransactionIDs(String[] relatedTransactionIDs) {
        this.relatedTransactionIDs = relatedTransactionIDs;
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
