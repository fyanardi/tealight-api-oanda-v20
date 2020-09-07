// This Java source file was generated on 2020-09-07 14:35:56 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import java.time.ZonedDateTime;
import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;

public class StopLossOrderRequest extends OrderRequest {
    private OrderType type = OrderType.STOP_LOSS;
    private String tradeID;
    private String clientTradeID;
    private Double price;
    private Double distance;
    private TimeInForce timeInForce = TimeInForce.GTC;
    private ZonedDateTime gtdTime;
    private OrderTriggerCondition triggerCondition = OrderTriggerCondition.DEFAULT;
    private Boolean guaranteed;
    private ClientExtensions clientExtensions;

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

    public Boolean getGuaranteed() {
        return guaranteed;
    }

    public void setGuaranteed(Boolean guaranteed) {
        this.guaranteed = guaranteed;
    }

    public ClientExtensions getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensions clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

}
