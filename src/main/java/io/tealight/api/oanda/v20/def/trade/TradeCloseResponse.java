// This Java source file was generated on 2020-10-08 18:45:40 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.MarketOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderCancelTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderFillTransaction;

public class TradeCloseResponse {
    private MarketOrderTransaction orderCreateTransaction;
    private OrderFillTransaction orderFillTransaction;
    private OrderCancelTransaction orderCancelTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;

    public MarketOrderTransaction getOrderCreateTransaction() {
        return orderCreateTransaction;
    }

    public void setOrderCreateTransaction(MarketOrderTransaction orderCreateTransaction) {
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
