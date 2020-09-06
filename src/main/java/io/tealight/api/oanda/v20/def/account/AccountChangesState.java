// This Java source file was generated on 2020-09-06 13:40:52 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import io.tealight.api.oanda.v20.def.order.DynamicOrderState;
import io.tealight.api.oanda.v20.def.trade.CalculatedTradeState;
import io.tealight.api.oanda.v20.def.position.CalculatedPositionState;

public class AccountChangesState extends AccumulatedAccountState {
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
    private DynamicOrderState[] orders;
    private CalculatedTradeState[] trades;
    private CalculatedPositionState[] positions;

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

    public DynamicOrderState[] getOrders() {
        return orders;
    }

    public void setOrders(DynamicOrderState[] orders) {
        this.orders = orders;
    }

    public CalculatedTradeState[] getTrades() {
        return trades;
    }

    public void setTrades(CalculatedTradeState[] trades) {
        this.trades = trades;
    }

    public CalculatedPositionState[] getPositions() {
        return positions;
    }

    public void setPositions(CalculatedPositionState[] positions) {
        this.positions = positions;
    }

}
