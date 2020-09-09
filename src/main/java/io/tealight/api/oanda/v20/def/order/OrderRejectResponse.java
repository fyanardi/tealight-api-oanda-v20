// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.def.transaction.Transaction;

public class OrderRejectResponse extends ErrorResponse {
    private Transaction orderRejectTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;
    private String errorCode;

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

}
