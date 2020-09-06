// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.position;

public class PositionSide {
    private Double units;
    private Double averagePrice;
    private String[] tradeIDs;
    private Double pl;
    private Double unrealizedPL;
    private Double resettablePL;
    private Double financing;
    private Double dividendAdjustment;
    private Double guaranteedExecutionFees;

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String[] getTradeIDs() {
        return tradeIDs;
    }

    public void setTradeIDs(String[] tradeIDs) {
        this.tradeIDs = tradeIDs;
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

}
