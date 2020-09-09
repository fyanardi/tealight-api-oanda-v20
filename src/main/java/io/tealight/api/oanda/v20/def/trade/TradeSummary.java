// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;
import java.time.ZonedDateTime;

public class TradeSummary {
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
    private String takeProfitOrderID;
    private String stopLossOrderID;
    private String guaranteedStopLossOrderID;
    private String trailingStopLossOrderID;

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

    public String getTakeProfitOrderID() {
        return takeProfitOrderID;
    }

    public void setTakeProfitOrderID(String takeProfitOrderID) {
        this.takeProfitOrderID = takeProfitOrderID;
    }

    public String getStopLossOrderID() {
        return stopLossOrderID;
    }

    public void setStopLossOrderID(String stopLossOrderID) {
        this.stopLossOrderID = stopLossOrderID;
    }

    public String getGuaranteedStopLossOrderID() {
        return guaranteedStopLossOrderID;
    }

    public void setGuaranteedStopLossOrderID(String guaranteedStopLossOrderID) {
        this.guaranteedStopLossOrderID = guaranteedStopLossOrderID;
    }

    public String getTrailingStopLossOrderID() {
        return trailingStopLossOrderID;
    }

    public void setTrailingStopLossOrderID(String trailingStopLossOrderID) {
        this.trailingStopLossOrderID = trailingStopLossOrderID;
    }

}
