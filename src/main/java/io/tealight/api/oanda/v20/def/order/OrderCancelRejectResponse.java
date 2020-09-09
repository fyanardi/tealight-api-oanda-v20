// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.def.transaction.OrderCancelRejectTransaction;

public class OrderCancelRejectResponse extends ErrorResponse {
    private OrderCancelRejectTransaction orderCancelRejectTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;
    private String errorCode;

    public OrderCancelRejectTransaction getOrderCancelRejectTransaction() {
        return orderCancelRejectTransaction;
    }

    public void setOrderCancelRejectTransaction(OrderCancelRejectTransaction orderCancelRejectTransaction) {
        this.orderCancelRejectTransaction = orderCancelRejectTransaction;
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
