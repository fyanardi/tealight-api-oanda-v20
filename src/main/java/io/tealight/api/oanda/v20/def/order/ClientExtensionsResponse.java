// This Java source file was generated on 2020-09-11 05:48:00 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.OrderClientExtensionsModifyTransaction;

public class ClientExtensionsResponse {
    private OrderClientExtensionsModifyTransaction orderClientExtensionsModifyTransaction;
    private String lastTransactionID;
    private String[] relatedTransactionIDs;

    public OrderClientExtensionsModifyTransaction getOrderClientExtensionsModifyTransaction() {
        return orderClientExtensionsModifyTransaction;
    }

    public void setOrderClientExtensionsModifyTransaction(OrderClientExtensionsModifyTransaction orderClientExtensionsModifyTransaction) {
        this.orderClientExtensionsModifyTransaction = orderClientExtensionsModifyTransaction;
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

}
