// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import java.time.ZonedDateTime;

public class AccumulatedAccountState {
    private Double balance;
    private Double pl;
    private Double resettablePL;
    private Double financing;
    private Double commission;
    private Double dividendAdjustment;
    private Double guaranteedExecutionFees;
    private ZonedDateTime marginCallEnterTime;
    private Integer marginCallExtensionCount;
    private ZonedDateTime lastMarginCallExtensionTime;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getPl() {
        return pl;
    }

    public void setPl(Double pl) {
        this.pl = pl;
    }

    public Double getResettablePL() {
        return resettablePL;
    }

    public void setResettablePL(Double resettablePL) {
        this.resettablePL = resettablePL;
    }

    public Double getFinancing() {
        return financing;
    }

    public void setFinancing(Double financing) {
        this.financing = financing;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getDividendAdjustment() {
        return dividendAdjustment;
    }

    public void setDividendAdjustment(Double dividendAdjustment) {
        this.dividendAdjustment = dividendAdjustment;
    }

    public Double getGuaranteedExecutionFees() {
        return guaranteedExecutionFees;
    }

    public void setGuaranteedExecutionFees(Double guaranteedExecutionFees) {
        this.guaranteedExecutionFees = guaranteedExecutionFees;
    }

    public ZonedDateTime getMarginCallEnterTime() {
        return marginCallEnterTime;
    }

    public void setMarginCallEnterTime(ZonedDateTime marginCallEnterTime) {
        this.marginCallEnterTime = marginCallEnterTime;
    }

    public Integer getMarginCallExtensionCount() {
        return marginCallExtensionCount;
    }

    public void setMarginCallExtensionCount(Integer marginCallExtensionCount) {
        this.marginCallExtensionCount = marginCallExtensionCount;
    }

    public ZonedDateTime getLastMarginCallExtensionTime() {
        return lastMarginCallExtensionTime;
    }

    public void setLastMarginCallExtensionTime(ZonedDateTime lastMarginCallExtensionTime) {
        this.lastMarginCallExtensionTime = lastMarginCallExtensionTime;
    }

}
