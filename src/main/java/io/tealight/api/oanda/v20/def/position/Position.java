// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.position;


public class Position {
    private String instrument;
    private Double pl;
    private Double unrealizedPL;
    private Double marginUsed;
    private Double resettablePL;
    private Double financing;
    private Double commission;
    private Double dividendAdjustment;
    private Double guaranteedExecutionFees;
    private PositionSide _long;
    private PositionSide _short;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Double getPl() {
        return pl;
    }

    public void setPl(Double pl) {
        this.pl = pl;
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

    public PositionSide getLong() {
        return _long;
    }

    public void setLong(PositionSide _long) {
        this._long = _long;
    }

    public PositionSide getShort() {
        return _short;
    }

    public void setShort(PositionSide _short) {
        this._short = _short;
    }

}
