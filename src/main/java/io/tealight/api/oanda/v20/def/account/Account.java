// This Java source file was generated on 2020-09-06 13:40:52 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import io.tealight.api.oanda.v20.def.trade.TradeSummary;
import io.tealight.api.oanda.v20.def.position.Position;
import io.tealight.api.oanda.v20.def.order.Order;

public class Account extends AccountSummary {
    private TradeSummary[] trades;
    private Position[] positions;
    private Order[] orders;

    public TradeSummary[] getTrades() {
        return trades;
    }

    public void setTrades(TradeSummary[] trades) {
        this.trades = trades;
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

}
