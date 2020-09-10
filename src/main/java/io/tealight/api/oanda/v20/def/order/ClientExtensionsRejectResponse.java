// This Java source file was generated on 2020-09-11 05:48:00 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.def.transaction.OrderClientExtensionsModifyRejectTransaction;

public class ClientExtensionsRejectResponse extends ErrorResponse {
    private OrderClientExtensionsModifyRejectTransaction orderClientExtensionsModifyRejectTransaction;
    private String lastTransactionID;
    private String[] relatedTransactionIDs;
    private String errorCode;

    public OrderClientExtensionsModifyRejectTransaction getOrderClientExtensionsModifyRejectTransaction() {
        return orderClientExtensionsModifyRejectTransaction;
    }

    public void setOrderClientExtensionsModifyRejectTransaction(OrderClientExtensionsModifyRejectTransaction orderClientExtensionsModifyRejectTransaction) {
        this.orderClientExtensionsModifyRejectTransaction = orderClientExtensionsModifyRejectTransaction;
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

}
