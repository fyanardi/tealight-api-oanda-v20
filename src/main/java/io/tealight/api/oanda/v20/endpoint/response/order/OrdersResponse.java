package io.tealight.api.oanda.v20.endpoint.response.order;

import java.util.List;

import io.tealight.api.oanda.v20.def.order.Order;

public class OrdersResponse {

    private String lastTransactionID;
    private List<Order> orders;

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
