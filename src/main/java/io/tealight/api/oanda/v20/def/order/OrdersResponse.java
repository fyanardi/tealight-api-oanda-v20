// This Java source file was generated on 2020-10-03 10:52:59 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

public class OrdersResponse {
    private Order[] orders;
    private String lastTransactionID;

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
