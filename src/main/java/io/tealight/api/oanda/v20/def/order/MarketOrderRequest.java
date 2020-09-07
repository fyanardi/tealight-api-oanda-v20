// This Java source file was generated on 2020-09-07 14:35:56 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitDetails;
import io.tealight.api.oanda.v20.def.transaction.StopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossDetails;

public class MarketOrderRequest extends OrderRequest {
    private OrderType type = OrderType.MARKET;
    private String instrument;
    private Double units;
    private TimeInForce timeInForce = TimeInForce.FOK;
    private Double priceBound;
    private OrderPositionFill positionFill = OrderPositionFill.DEFAULT;
    private ClientExtensions clientExtensions;
    private TakeProfitDetails takeProfitOnFill;
    private StopLossDetails stopLossOnFill;
    private GuaranteedStopLossDetails guaranteedStopLossOnFill;
    private TrailingStopLossDetails trailingStopLossOnFill;
    private ClientExtensions tradeClientExtensions;

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

}
