// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

public class TradeReduce {
    private String tradeID;
    private Double units;
    private Double price;
    private Double realizedPL;
    private Double financing;
    private Double guaranteedExecutionFee;
    private Double halfSpreadCost;

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
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

    public Double getRealizedPL() {
        return realizedPL;
    }

    public void setRealizedPL(Double realizedPL) {
        this.realizedPL = realizedPL;
    }

    public Double getFinancing() {
        return financing;
    }

    public void setFinancing(Double financing) {
        this.financing = financing;
    }

    public Double getGuaranteedExecutionFee() {
        return guaranteedExecutionFee;
    }

    public void setGuaranteedExecutionFee(Double guaranteedExecutionFee) {
        this.guaranteedExecutionFee = guaranteedExecutionFee;
    }

    public Double getHalfSpreadCost() {
        return halfSpreadCost;
    }

    public void setHalfSpreadCost(Double halfSpreadCost) {
        this.halfSpreadCost = halfSpreadCost;
    }

}
