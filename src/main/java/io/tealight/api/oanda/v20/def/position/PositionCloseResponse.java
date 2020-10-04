// This Java source file was generated on 2020-10-04 10:19:15 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.position;

import io.tealight.api.oanda.v20.def.transaction.MarketOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderCancelTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderFillTransaction;

public class PositionCloseResponse {
    private MarketOrderTransaction longOrderCreateTransaction;
    private OrderFillTransaction longOrderFillTransaction;
    private OrderCancelTransaction longOrderCancelTransaction;
    private MarketOrderTransaction shortOrderCreateTransaction;
    private OrderFillTransaction shortOrderFillTransaction;
    private OrderCancelTransaction shortOrderCancelTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;

    public MarketOrderTransaction getLongOrderCreateTransaction() {
        return longOrderCreateTransaction;
    }

    public void setLongOrderCreateTransaction(MarketOrderTransaction longOrderCreateTransaction) {
        this.longOrderCreateTransaction = longOrderCreateTransaction;
    }

    public OrderFillTransaction getLongOrderFillTransaction() {
        return longOrderFillTransaction;
    }

    public void setLongOrderFillTransaction(OrderFillTransaction longOrderFillTransaction) {
        this.longOrderFillTransaction = longOrderFillTransaction;
    }

    public OrderCancelTransaction getLongOrderCancelTransaction() {
        return longOrderCancelTransaction;
    }

    public void setLongOrderCancelTransaction(OrderCancelTransaction longOrderCancelTransaction) {
        this.longOrderCancelTransaction = longOrderCancelTransaction;
    }

    public MarketOrderTransaction getShortOrderCreateTransaction() {
        return shortOrderCreateTransaction;
    }

    public void setShortOrderCreateTransaction(MarketOrderTransaction shortOrderCreateTransaction) {
        this.shortOrderCreateTransaction = shortOrderCreateTransaction;
    }

    public OrderFillTransaction getShortOrderFillTransaction() {
        return shortOrderFillTransaction;
    }

    public void setShortOrderFillTransaction(OrderFillTransaction shortOrderFillTransaction) {
        this.shortOrderFillTransaction = shortOrderFillTransaction;
    }

    public OrderCancelTransaction getShortOrderCancelTransaction() {
        return shortOrderCancelTransaction;
    }

    public void setShortOrderCancelTransaction(OrderCancelTransaction shortOrderCancelTransaction) {
        this.shortOrderCancelTransaction = shortOrderCancelTransaction;
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
