// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.order.OrderPositionFill;
import io.tealight.api.oanda.v20.def.order.OrderTriggerCondition;
import io.tealight.api.oanda.v20.def.order.TimeInForce;
import java.time.ZonedDateTime;

public class LimitOrderTransaction extends Transaction {
    private TransactionType type = TransactionType.LIMIT_ORDER;
    private String instrument;
    private Double units;
    private Double price;
    private TimeInForce timeInForce = TimeInForce.GTC;
    private ZonedDateTime gtdTime;
    private OrderPositionFill positionFill = OrderPositionFill.DEFAULT;
    private OrderTriggerCondition triggerCondition = OrderTriggerCondition.DEFAULT;
    private LimitOrderReason reason;
    private ClientExtensions clientExtensions;
    private TakeProfitDetails takeProfitOnFill;
    private StopLossDetails stopLossOnFill;
    private TrailingStopLossDetails trailingStopLossOnFill;
    private GuaranteedStopLossDetails guaranteedStopLossOnFill;
    private ClientExtensions tradeClientExtensions;
    private String replacesOrderID;
    private String cancellingTransactionID;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public OrderPositionFill getPositionFill() {
        return positionFill;
    }

    public void setPositionFill(OrderPositionFill positionFill) {
        this.positionFill = positionFill;
    }

    public OrderTriggerCondition getTriggerCondition() {
        return triggerCondition;
    }

    public void setTriggerCondition(OrderTriggerCondition triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public LimitOrderReason getReason() {
        return reason;
    }

    public void setReason(LimitOrderReason reason) {
        this.reason = reason;
    }

    public ClientExtensions getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensions clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

    public TakeProfitDetails getTakeProfitOnFill() {
        return takeProfitOnFill;
    }

    public void setTakeProfitOnFill(TakeProfitDetails takeProfitOnFill) {
        this.takeProfitOnFill = takeProfitOnFill;
    }

    public StopLossDetails getStopLossOnFill() {
        return stopLossOnFill;
    }

    public void setStopLossOnFill(StopLossDetails stopLossOnFill) {
        this.stopLossOnFill = stopLossOnFill;
    }

    public TrailingStopLossDetails getTrailingStopLossOnFill() {
        return trailingStopLossOnFill;
    }

    public void setTrailingStopLossOnFill(TrailingStopLossDetails trailingStopLossOnFill) {
        this.trailingStopLossOnFill = trailingStopLossOnFill;
    }

    public GuaranteedStopLossDetails getGuaranteedStopLossOnFill() {
        return guaranteedStopLossOnFill;
    }

    public void setGuaranteedStopLossOnFill(GuaranteedStopLossDetails guaranteedStopLossOnFill) {
        this.guaranteedStopLossOnFill = guaranteedStopLossOnFill;
    }

    public ClientExtensions getTradeClientExtensions() {
        return tradeClientExtensions;
    }

    public void setTradeClientExtensions(ClientExtensions tradeClientExtensions) {
        this.tradeClientExtensions = tradeClientExtensions;
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
