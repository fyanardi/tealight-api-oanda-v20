// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.MarketOrderTradeClose;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderPositionCloseout;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderMarginCloseout;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderDelayedTradeClose;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitDetails;
import io.tealight.api.oanda.v20.def.transaction.StopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;
import java.time.ZonedDateTime;

public class MarketOrder extends Order {
    private OrderType type = OrderType.MARKET;
    private String instrument;
    private Double units;
    private TimeInForce timeInForce = TimeInForce.FOK;
    private Double priceBound;
    private OrderPositionFill positionFill = OrderPositionFill.DEFAULT;
    private MarketOrderTradeClose tradeClose;
    private MarketOrderPositionCloseout longPositionCloseout;
    private MarketOrderPositionCloseout shortPositionCloseout;
    private MarketOrderMarginCloseout marginCloseout;
    private MarketOrderDelayedTradeClose delayedTradeClose;
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

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public Double getPriceBound() {
        return priceBound;
    }

    public void setPriceBound(Double priceBound) {
        this.priceBound = priceBound;
    }

    public OrderPositionFill getPositionFill() {
        return positionFill;
    }

    public void setPositionFill(OrderPositionFill positionFill) {
        this.positionFill = positionFill;
    }

    public MarketOrderTradeClose getTradeClose() {
        return tradeClose;
    }

    public void setTradeClose(MarketOrderTradeClose tradeClose) {
        this.tradeClose = tradeClose;
    }

    public MarketOrderPositionCloseout getLongPositionCloseout() {
        return longPositionCloseout;
    }

    public void setLongPositionCloseout(MarketOrderPositionCloseout longPositionCloseout) {
        this.longPositionCloseout = longPositionCloseout;
    }

    public MarketOrderPositionCloseout getShortPositionCloseout() {
        return shortPositionCloseout;
    }

    public void setShortPositionCloseout(MarketOrderPositionCloseout shortPositionCloseout) {
        this.shortPositionCloseout = shortPositionCloseout;
    }

    public MarketOrderMarginCloseout getMarginCloseout() {
        return marginCloseout;
    }

    public void setMarginCloseout(MarketOrderMarginCloseout marginCloseout) {
        this.marginCloseout = marginCloseout;
    }

    public MarketOrderDelayedTradeClose getDelayedTradeClose() {
        return delayedTradeClose;
    }

    public void setDelayedTradeClose(MarketOrderDelayedTradeClose delayedTradeClose) {
        this.delayedTradeClose = delayedTradeClose;
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

}
