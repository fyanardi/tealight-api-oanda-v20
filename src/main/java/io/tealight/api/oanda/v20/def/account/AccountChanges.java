// This Java source file was generated on 2020-09-06 13:40:52 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import io.tealight.api.oanda.v20.def.order.Order;
import io.tealight.api.oanda.v20.def.trade.TradeSummary;
import io.tealight.api.oanda.v20.def.position.Position;
import io.tealight.api.oanda.v20.def.transaction.Transaction;

public class AccountChanges {
    private Order[] ordersCreated;
    private Order[] ordersCancelled;
    private Order[] ordersFilled;
    private Order[] ordersTriggered;
    private TradeSummary[] tradesOpened;
    private TradeSummary[] tradesReduced;
    private TradeSummary[] tradesClosed;
    private Position[] positions;
    private Transaction[] transactions;

    public Order[] getOrdersCreated() {
        return ordersCreated;
    }

    public void setOrdersCreated(Order[] ordersCreated) {
        this.ordersCreated = ordersCreated;
    }

    public Order[] getOrdersCancelled() {
        return ordersCancelled;
    }

    public void setOrdersCancelled(Order[] ordersCancelled) {
        this.ordersCancelled = ordersCancelled;
    }

    public Order[] getOrdersFilled() {
        return ordersFilled;
    }

    public void setOrdersFilled(Order[] ordersFilled) {
        this.ordersFilled = ordersFilled;
    }

    public Order[] getOrdersTriggered() {
        return ordersTriggered;
    }

    public void setOrdersTriggered(Order[] ordersTriggered) {
        this.ordersTriggered = ordersTriggered;
    }

    public TradeSummary[] getTradesOpened() {
        return tradesOpened;
    }

    public void setTradesOpened(TradeSummary[] tradesOpened) {
        this.tradesOpened = tradesOpened;
    }

    public TradeSummary[] getTradesReduced() {
        return tradesReduced;
    }

    public void setTradesReduced(TradeSummary[] tradesReduced) {
        this.tradesReduced = tradesReduced;
    }

    public TradeSummary[] getTradesClosed() {
        return tradesClosed;
    }

    public void setTradesClosed(TradeSummary[] tradesClosed) {
        this.tradesClosed = tradesClosed;
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

}
