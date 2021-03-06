// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.order.OrderTriggerCondition;
import io.tealight.api.oanda.v20.def.order.TimeInForce;
import java.time.ZonedDateTime;

public class TrailingStopLossOrderRejectTransaction extends Transaction {
    private TransactionType type = TransactionType.TRAILING_STOP_LOSS_ORDER_REJECT;
    private String tradeID;
    private String clientTradeID;
    private Double distance;
    private TimeInForce timeInForce = TimeInForce.GTC;
    private ZonedDateTime gtdTime;
    private OrderTriggerCondition triggerCondition = OrderTriggerCondition.DEFAULT;
    private TrailingStopLossOrderReason reason;
    private ClientExtensions clientExtensions;
    private String orderFillTransactionID;
    private String intendedReplacesOrderID;
    private TransactionRejectReason rejectReason;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public String getClientTradeID() {
        return clientTradeID;
    }

    public void setClientTradeID(String clientTradeID) {
        this.clientTradeID = clientTradeID;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public ZonedDateTime getGtdTime() {
        return gtdTime;
    }

    public void setGtdTime(ZonedDateTime gtdTime) {
        this.gtdTime = gtdTime;
    }

    public OrderTriggerCondition getTriggerCondition() {
        return triggerCondition;
    }

    public void setTriggerCondition(OrderTriggerCondition triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public TrailingStopLossOrderReason getReason() {
        return reason;
    }

    public void setReason(TrailingStopLossOrderReason reason) {
        this.reason = reason;
    }

    public ClientExtensions getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensions clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

    public String getOrderFillTransactionID() {
        return orderFillTransactionID;
    }

    public void setOrderFillTransactionID(String orderFillTransactionID) {
        this.orderFillTransactionID = orderFillTransactionID;
    }

    public String getIntendedReplacesOrderID() {
        return intendedReplacesOrderID;
    }

    public void setIntendedReplacesOrderID(String intendedReplacesOrderID) {
        this.intendedReplacesOrderID = intendedReplacesOrderID;
    }

    public TransactionRejectReason getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(TransactionRejectReason rejectReason) {
        this.rejectReason = rejectReason;
    }

}
