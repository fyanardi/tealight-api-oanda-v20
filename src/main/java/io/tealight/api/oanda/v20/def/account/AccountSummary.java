// This Java source file was generated on 2020-09-09 10:37:58 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import java.time.ZonedDateTime;
import java.util.Currency;

public class AccountSummary extends AccumulatedAccountState {
    private String id;
    private String alias;
    private Currency currency;
    private Integer createdByUserID;
    private ZonedDateTime createdTime;
    private GuaranteedStopLossOrderMode guaranteedStopLossOrderMode;
    private GuaranteedStopLossOrderMutability guaranteedStopLossOrderMutability;
    private ZonedDateTime resettablePLTime;
    private Double marginRate;
    private Integer openTradeCount;
    private Integer openPositionCount;
    private Integer pendingOrderCount;
    private Boolean hedgingEnabled;
    private Double unrealizedPL;
    private Double NAV;
    private Double marginUsed;
    private Double marginAvailable;
    private Double positionValue;
    private Double marginCloseoutUnrealizedPL;
    private Double marginCloseoutNAV;
    private Double marginCloseoutMarginUsed;
    private Double marginCloseoutPercent;
    private Double marginCloseoutPositionValue;
    private Double withdrawalLimit;
    private Double marginCallMarginUsed;
    private Double marginCallPercent;
    private String lastTransactionID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getCreatedByUserID() {
        return createdByUserID;
    }

    public void setCreatedByUserID(Integer createdByUserID) {
        this.createdByUserID = createdByUserID;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public GuaranteedStopLossOrderMode getGuaranteedStopLossOrderMode() {
        return guaranteedStopLossOrderMode;
    }

    public void setGuaranteedStopLossOrderMode(GuaranteedStopLossOrderMode guaranteedStopLossOrderMode) {
        this.guaranteedStopLossOrderMode = guaranteedStopLossOrderMode;
    }

    public GuaranteedStopLossOrderMutability getGuaranteedStopLossOrderMutability() {
        return guaranteedStopLossOrderMutability;
    }

    public void setGuaranteedStopLossOrderMutability(GuaranteedStopLossOrderMutability guaranteedStopLossOrderMutability) {
        this.guaranteedStopLossOrderMutability = guaranteedStopLossOrderMutability;
    }

    public ZonedDateTime getResettablePLTime() {
        return resettablePLTime;
    }

    public void setResettablePLTime(ZonedDateTime resettablePLTime) {
        this.resettablePLTime = resettablePLTime;
    }

    public Double getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(Double marginRate) {
        this.marginRate = marginRate;
    }

    public Integer getOpenTradeCount() {
        return openTradeCount;
    }

    public void setOpenTradeCount(Integer openTradeCount) {
        this.openTradeCount = openTradeCount;
    }

    public Integer getOpenPositionCount() {
        return openPositionCount;
    }

    public void setOpenPositionCount(Integer openPositionCount) {
        this.openPositionCount = openPositionCount;
    }

    public Integer getPendingOrderCount() {
        return pendingOrderCount;
    }

    public void setPendingOrderCount(Integer pendingOrderCount) {
        this.pendingOrderCount = pendingOrderCount;
    }

    public Boolean getHedgingEnabled() {
        return hedgingEnabled;
    }

    public void setHedgingEnabled(Boolean hedgingEnabled) {
        this.hedgingEnabled = hedgingEnabled;
    }

    public Double getUnrealizedPL() {
        return unrealizedPL;
    }

    public void setUnrealizedPL(Double unrealizedPL) {
        this.unrealizedPL = unrealizedPL;
    }

    public Double getNAV() {
        return NAV;
    }

    public void setNAV(Double NAV) {
        this.NAV = NAV;
    }

    public Double getMarginUsed() {
        return marginUsed;
    }

    public void setMarginUsed(Double marginUsed) {
        this.marginUsed = marginUsed;
    }

    public Double getMarginAvailable() {
        return marginAvailable;
    }

    public void setMarginAvailable(Double marginAvailable) {
        this.marginAvailable = marginAvailable;
    }

    public Double getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(Double positionValue) {
        this.positionValue = positionValue;
    }

    public Double getMarginCloseoutUnrealizedPL() {
        return marginCloseoutUnrealizedPL;
    }

    public void setMarginCloseoutUnrealizedPL(Double marginCloseoutUnrealizedPL) {
        this.marginCloseoutUnrealizedPL = marginCloseoutUnrealizedPL;
    }

    public Double getMarginCloseoutNAV() {
        return marginCloseoutNAV;
    }

    public void setMarginCloseoutNAV(Double marginCloseoutNAV) {
        this.marginCloseoutNAV = marginCloseoutNAV;
    }

    public Double getMarginCloseoutMarginUsed() {
        return marginCloseoutMarginUsed;
    }

    public void setMarginCloseoutMarginUsed(Double marginCloseoutMarginUsed) {
        this.marginCloseoutMarginUsed = marginCloseoutMarginUsed;
    }

    public Double getMarginCloseoutPercent() {
        return marginCloseoutPercent;
    }

    public void setMarginCloseoutPercent(Double marginCloseoutPercent) {
        this.marginCloseoutPercent = marginCloseoutPercent;
    }

    public Double getMarginCloseoutPositionValue() {
        return marginCloseoutPositionValue;
    }

    public void setMarginCloseoutPositionValue(Double marginCloseoutPositionValue) {
        this.marginCloseoutPositionValue = marginCloseoutPositionValue;
    }

    public Double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(Double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public Double getMarginCallMarginUsed() {
        return marginCallMarginUsed;
    }

    public void setMarginCallMarginUsed(Double marginCallMarginUsed) {
        this.marginCallMarginUsed = marginCallMarginUsed;
    }

    public Double getMarginCallPercent() {
        return marginCallPercent;
    }

    public void setMarginCallPercent(Double marginCallPercent) {
        this.marginCallPercent = marginCallPercent;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
