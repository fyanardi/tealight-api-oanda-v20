// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.order.TimeInForce;
import io.tealight.api.oanda.v20.def.order.OrderPositionFill;

public class MarketOrderRejectTransaction extends Transaction {
    private TransactionType type = TransactionType.MARKET_ORDER_REJECT;
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
    private MarketOrderReason reason;
    private ClientExtensions clientExtensions;
    private TakeProfitDetails takeProfitOnFill;
    private StopLossDetails stopLossOnFill;
    private TrailingStopLossDetails trailingStopLossOnFill;
    private GuaranteedStopLossDetails guaranteedStopLossOnFill;
    private ClientExtensions tradeClientExtensions;
    private TransactionRejectReason rejectReason;

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

    public MarketOrderReason getReason() {
        return reason;
    }

    public void setReason(MarketOrderReason reason) {
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

    public TransactionRejectReason getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(TransactionRejectReason rejectReason) {
        this.rejectReason = rejectReason;
    }

}
