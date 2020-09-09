// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

public class TradeOpen {
    private String tradeID;
    private Double units;
    private Double price;
    private Double guaranteedExecutionFee;
    private ClientExtensions clientExtensions;
    private Double halfSpreadCost;
    private Double initialMarginRequired;

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

    public Double getGuaranteedExecutionFee() {
        return guaranteedExecutionFee;
    }

    public void setGuaranteedExecutionFee(Double guaranteedExecutionFee) {
        this.guaranteedExecutionFee = guaranteedExecutionFee;
    }

    public ClientExtensions getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensions clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

    public Double getHalfSpreadCost() {
        return halfSpreadCost;
    }

    public void setHalfSpreadCost(Double halfSpreadCost) {
        this.halfSpreadCost = halfSpreadCost;
    }

    public Double getInitialMarginRequired() {
        return initialMarginRequired;
    }

    public void setInitialMarginRequired(Double initialMarginRequired) {
        this.initialMarginRequired = initialMarginRequired;
    }

}
