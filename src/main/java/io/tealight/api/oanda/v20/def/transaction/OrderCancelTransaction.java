// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

public class OrderCancelTransaction extends Transaction {
    private TransactionType type = TransactionType.ORDER_CANCEL;
    private String orderID;
    private String clientOrderID;
    private OrderCancelReason reason;
    private String replacedByOrderID;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getClientOrderID() {
        return clientOrderID;
    }

    public void setClientOrderID(String clientOrderID) {
        this.clientOrderID = clientOrderID;
    }

    public OrderCancelReason getReason() {
        return reason;
    }

    public void setReason(OrderCancelReason reason) {
        this.reason = reason;
    }

    public String getReplacedByOrderID() {
        return replacedByOrderID;
    }

    public void setReplacedByOrderID(String replacedByOrderID) {
        this.replacedByOrderID = replacedByOrderID;
    }

}
