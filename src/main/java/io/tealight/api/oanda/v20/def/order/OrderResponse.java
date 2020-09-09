// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.OrderCancelTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderFillTransaction;
import io.tealight.api.oanda.v20.def.transaction.Transaction;

public class OrderResponse {
    private Transaction orderCreateTransaction;
    private OrderFillTransaction orderFillTransaction;
    private OrderCancelTransaction orderCancelTransaction;
    private Transaction orderReissueTransaction;
    private Transaction orderReissueRejectTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;

    public Transaction getOrderCreateTransaction() {
        return orderCreateTransaction;
    }

    public void setOrderCreateTransaction(Transaction orderCreateTransaction) {
        this.orderCreateTransaction = orderCreateTransaction;
    }

    public OrderFillTransaction getOrderFillTransaction() {
        return orderFillTransaction;
    }

    public void setOrderFillTransaction(OrderFillTransaction orderFillTransaction) {
        this.orderFillTransaction = orderFillTransaction;
    }

    public OrderCancelTransaction getOrderCancelTransaction() {
        return orderCancelTransaction;
    }

    public void setOrderCancelTransaction(OrderCancelTransaction orderCancelTransaction) {
        this.orderCancelTransaction = orderCancelTransaction;
    }

    public Transaction getOrderReissueTransaction() {
        return orderReissueTransaction;
    }

    public void setOrderReissueTransaction(Transaction orderReissueTransaction) {
        this.orderReissueTransaction = orderReissueTransaction;
    }

    public Transaction getOrderReissueRejectTransaction() {
        return orderReissueRejectTransaction;
    }

    public void setOrderReissueRejectTransaction(Transaction orderReissueRejectTransaction) {
        this.orderReissueRejectTransaction = orderReissueRejectTransaction;
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

}
