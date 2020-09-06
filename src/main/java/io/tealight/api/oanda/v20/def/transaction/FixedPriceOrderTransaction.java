// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.order.OrderPositionFill;

public class FixedPriceOrderTransaction extends Transaction {
    private TransactionType type = TransactionType.FIXED_PRICE_ORDER;
    private String instrument;
    private Double units;
    private Double price;
    private OrderPositionFill positionFill = OrderPositionFill.DEFAULT;
    private String tradeState;
    private FixedPriceOrderReason reason;
    private ClientExtensions clientExtensions;
    private TakeProfitDetails takeProfitOnFill;
    private StopLossDetails stopLossOnFill;
    private TrailingStopLossDetails trailingStopLossOnFill;
    private GuaranteedStopLossDetails guaranteedStopLossOnFill;
    private ClientExtensions tradeClientExtensions;

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

    public OrderPositionFill getPositionFill() {
        return positionFill;
    }

    public void setPositionFill(OrderPositionFill positionFill) {
        this.positionFill = positionFill;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public FixedPriceOrderReason getReason() {
        return reason;
    }

    public void setReason(FixedPriceOrderReason reason) {
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

}
