// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import java.time.ZonedDateTime;
import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;
import io.tealight.api.oanda.v20.def.order.TakeProfitOrder;
import io.tealight.api.oanda.v20.def.order.StopLossOrder;
import io.tealight.api.oanda.v20.def.order.TrailingStopLossOrder;

public class Trade {
    private String id;
    private String instrument;
    private Double price;
    private ZonedDateTime openTime;
    private TradeState state;
    private Double initialUnits;
    private Double initialMarginRequired;
    private Double currentUnits;
    private Double realizedPL;
    private Double unrealizedPL;
    private Double marginUsed;
    private Double averageClosePrice;
    private String[] closingTransactionIDs;
    private Double financing;
    private Double dividendAdjustment;
    private ZonedDateTime closeTime;
    private ClientExtensions clientExtensions;
    private TakeProfitOrder takeProfitOrder;
    private StopLossOrder stopLossOrder;
    private TrailingStopLossOrder trailingStopLossOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ZonedDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(ZonedDateTime openTime) {
        this.openTime = openTime;
    }

    public TradeState getState() {
        return state;
    }

    public void setState(TradeState state) {
        this.state = state;
    }

    public Double getInitialUnits() {
        return initialUnits;
    }

    public void setInitialUnits(Double initialUnits) {
        this.initialUnits = initialUnits;
    }

    public Double getInitialMarginRequired() {
        return initialMarginRequired;
    }

    public void setInitialMarginRequired(Double initialMarginRequired) {
        this.initialMarginRequired = initialMarginRequired;
    }

    public Double getCurrentUnits() {
        return currentUnits;
    }

    public void setCurrentUnits(Double currentUnits) {
        this.currentUnits = currentUnits;
    }

    public Double getRealizedPL() {
        return realizedPL;
    }

    public void setRealizedPL(Double realizedPL) {
        this.realizedPL = realizedPL;
    }

    public Double getUnrealizedPL() {
        return unrealizedPL;
    }

    public void setUnrealizedPL(Double unrealizedPL) {
        this.unrealizedPL = unrealizedPL;
    }

    public Double getMarginUsed() {
        return marginUsed;
    }

    public void setMarginUsed(Double marginUsed) {
        this.marginUsed = marginUsed;
    }

    public Double getAverageClosePrice() {
        return averageClosePrice;
    }

    public void setAverageClosePrice(Double averageClosePrice) {
        this.averageClosePrice = averageClosePrice;
    }

    public String[] getClosingTransactionIDs() {
        return closingTransactionIDs;
    }

    public void setClosingTransactionIDs(String[] closingTransactionIDs) {
        this.closingTransactionIDs = closingTransactionIDs;
    }

    public Double getFinancing() {
        return financing;
    }

    public void setFinancing(Double financing) {
        this.financing = financing;
    }

    public Double getDividendAdjustment() {
        return dividendAdjustment;
    }

    public void setDividendAdjustment(Double dividendAdjustment) {
        this.dividendAdjustment = dividendAdjustment;
    }

    public ZonedDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(ZonedDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public ClientExtensions getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensions clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

    public TakeProfitOrder getTakeProfitOrder() {
        return takeProfitOrder;
    }

    public void setTakeProfitOrder(TakeProfitOrder takeProfitOrder) {
        this.takeProfitOrder = takeProfitOrder;
    }

    public StopLossOrder getStopLossOrder() {
        return stopLossOrder;
    }

    public void setStopLossOrder(StopLossOrder stopLossOrder) {
        this.stopLossOrder = stopLossOrder;
    }

    public TrailingStopLossOrder getTrailingStopLossOrder() {
        return trailingStopLossOrder;
    }

    public void setTrailingStopLossOrder(TrailingStopLossOrder trailingStopLossOrder) {
        this.trailingStopLossOrder = trailingStopLossOrder;
    }

}
