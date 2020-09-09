// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;
import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.StopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitDetails;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossDetails;
import java.time.ZonedDateTime;

public class MarketIfTouchedOrder extends Order {
    private OrderType type = OrderType.MARKET_IF_TOUCHED;
    private String instrument;
    private Double units;
    private Double price;
    private Double priceBound;
    private TimeInForce timeInForce = TimeInForce.GTC;
    private ZonedDateTime gtdTime;
    private OrderPositionFill positionFill = OrderPositionFill.DEFAULT;
    private OrderTriggerCondition triggerCondition = OrderTriggerCondition.DEFAULT;
    private Double initialMarketPrice;
    private TakeProfitDetails takeProfitOnFill;
    private StopLossDetails stopLossOnFill;
    private GuaranteedStopLossDetails guaranteedStopLossOnFill;
    private TrailingStopLossDetails trailingStopLossOnFill;
    private ClientExtensions tradeClientExtensions;
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

    public Double getPriceBound() {
        return priceBound;
    }

    public void setPriceBound(Double priceBound) {
        this.priceBound = priceBound;
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

    public Double getInitialMarketPrice() {
        return initialMarketPrice;
    }

    public void setInitialMarketPrice(Double initialMarketPrice) {
        this.initialMarketPrice = initialMarketPrice;
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

    public GuaranteedStopLossDetails getGuaranteedStopLossOnFill() {
        return guaranteedStopLossOnFill;
    }

    public void setGuaranteedStopLossOnFill(GuaranteedStopLossDetails guaranteedStopLossOnFill) {
        this.guaranteedStopLossOnFill = guaranteedStopLossOnFill;
    }

    public TrailingStopLossDetails getTrailingStopLossOnFill() {
        return trailingStopLossOnFill;
    }

    public void setTrailingStopLossOnFill(TrailingStopLossDetails trailingStopLossOnFill) {
        this.trailingStopLossOnFill = trailingStopLossOnFill;
    }

    public ClientExtensions getTradeClientExtensions() {
        return tradeClientExtensions;
    }

    public void setTradeClientExtensions(ClientExtensions tradeClientExtensions) {
        this.tradeClientExtensions = tradeClientExtensions;
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
