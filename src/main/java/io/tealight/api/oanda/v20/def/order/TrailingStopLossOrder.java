// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import java.time.ZonedDateTime;

public class TrailingStopLossOrder extends Order {
    private OrderType type = OrderType.TRAILING_STOP_LOSS;
    private String tradeID;
    private String clientTradeID;
    private Double distance;
    private TimeInForce timeInForce = TimeInForce.GTC;
    private ZonedDateTime gtdTime;
    private OrderTriggerCondition triggerCondition = OrderTriggerCondition.DEFAULT;
    private Double trailingStopValue;
    private String fillingTransactionID;
    private ZonedDateTime filledTime;
    private String tradeOpenedID;
    private String tradeReducedID;
    private String[] tradeClosedIDs;
    private String cancellingTransactionID;
    private ZonedDateTime cancelledTime;
    private String replacesOrderID;
    private String replacedByOrderID;

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
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

    public Double getTrailingStopValue() {
        return trailingStopValue;
    }

    public void setTrailingStopValue(Double trailingStopValue) {
        this.trailingStopValue = trailingStopValue;
    }

    public String getFillingTransactionID() {
        return fillingTransactionID;
    }

    public void setFillingTransactionID(String fillingTransactionID) {
        this.fillingTransactionID = fillingTransactionID;
    }

    public ZonedDateTime getFilledTime() {
        return filledTime;
    }

    public void setFilledTime(ZonedDateTime filledTime) {
        this.filledTime = filledTime;
    }

    public String getTradeOpenedID() {
        return tradeOpenedID;
    }

    public void setTradeOpenedID(String tradeOpenedID) {
        this.tradeOpenedID = tradeOpenedID;
    }

    public String getTradeReducedID() {
        return tradeReducedID;
    }

    public void setTradeReducedID(String tradeReducedID) {
        this.tradeReducedID = tradeReducedID;
    }

    public String[] getTradeClosedIDs() {
        return tradeClosedIDs;
    }

    public void setTradeClosedIDs(String[] tradeClosedIDs) {
        this.tradeClosedIDs = tradeClosedIDs;
    }

    public String getCancellingTransactionID() {
        return cancellingTransactionID;
    }

    public void setCancellingTransactionID(String cancellingTransactionID) {
        this.cancellingTransactionID = cancellingTransactionID;
    }

    public ZonedDateTime getCancelledTime() {
        return cancelledTime;
    }

    public void setCancelledTime(ZonedDateTime cancelledTime) {
        this.cancelledTime = cancelledTime;
    }

    public String getReplacesOrderID() {
        return replacesOrderID;
    }

    public void setReplacesOrderID(String replacesOrderID) {
        this.replacesOrderID = replacesOrderID;
    }

    public String getReplacedByOrderID() {
        return replacedByOrderID;
    }

    public void setReplacedByOrderID(String replacedByOrderID) {
        this.replacedByOrderID = replacedByOrderID;
    }

}
