// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.order.TimeInForce;
import java.time.ZonedDateTime;
import io.tealight.api.oanda.v20.def.order.OrderTriggerCondition;

public class GuaranteedStopLossOrderTransaction extends Transaction {
    private TransactionType type = TransactionType.GUARANTEED_STOP_LOSS_ORDER;
    private String tradeID;
    private String clientTradeID;
    private Double price;
    private Double distance;
    private TimeInForce timeInForce = TimeInForce.GTC;
    private ZonedDateTime gtdTime;
    private OrderTriggerCondition triggerCondition = OrderTriggerCondition.DEFAULT;
    private Double guaranteedExecutionPremium;
    private GuaranteedStopLossOrderReason reason;
    private ClientExtensions clientExtensions;
    private String orderFillTransactionID;
    private String replacesOrderID;
    private String cancellingTransactionID;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Double getGuaranteedExecutionPremium() {
        return guaranteedExecutionPremium;
    }

    public void setGuaranteedExecutionPremium(Double guaranteedExecutionPremium) {
        this.guaranteedExecutionPremium = guaranteedExecutionPremium;
    }

    public GuaranteedStopLossOrderReason getReason() {
        return reason;
    }

    public void setReason(GuaranteedStopLossOrderReason reason) {
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

    public String getReplacesOrderID() {
        return replacesOrderID;
    }

    public void setReplacesOrderID(String replacesOrderID) {
        this.replacesOrderID = replacesOrderID;
    }

    public String getCancellingTransactionID() {
        return cancellingTransactionID;
    }

    public void setCancellingTransactionID(String cancellingTransactionID) {
        this.cancellingTransactionID = cancellingTransactionID;
    }

}
