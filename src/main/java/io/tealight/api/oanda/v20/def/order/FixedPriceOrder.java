// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.transaction.TakeProfitDetails;
import io.tealight.api.oanda.v20.def.transaction.StopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;
import java.time.ZonedDateTime;

public class FixedPriceOrder extends Order {
    private OrderType type = OrderType.FIXED_PRICE;
    private String instrument;
    private Double units;
    private Double price;
    private OrderPositionFill positionFill = OrderPositionFill.DEFAULT;
    private String tradeState;
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
