// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.pricing.ClientPrice;

public class OrderFillTransaction extends Transaction {
    private TransactionType type = TransactionType.ORDER_FILL;
    private String orderID;
    private String clientOrderID;
    private String instrument;
    private Double units;
    private Double gainQuoteHomeConversionFactor;
    private Double lossQuoteHomeConversionFactor;
    private Double price;
    private Double fullVWAP;
    private ClientPrice fullPrice;
    private OrderFillReason reason;
    private Double pl;
    private Double financing;
    private Double commission;
    private Double guaranteedExecutionFee;
    private Double accountBalance;
    private TradeOpen tradeOpened;
    private TradeReduce[] tradesClosed;
    private TradeReduce tradeReduced;
    private Double halfSpreadCost;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getClientOrderID() {
        return clientOrderID;
    }

    public void setClientOrderID(String clientOrderID) {
        this.clientOrderID = clientOrderID;
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

    public Double getGainQuoteHomeConversionFactor() {
        return gainQuoteHomeConversionFactor;
    }

    public void setGainQuoteHomeConversionFactor(Double gainQuoteHomeConversionFactor) {
        this.gainQuoteHomeConversionFactor = gainQuoteHomeConversionFactor;
    }

    public Double getLossQuoteHomeConversionFactor() {
        return lossQuoteHomeConversionFactor;
    }

    public void setLossQuoteHomeConversionFactor(Double lossQuoteHomeConversionFactor) {
        this.lossQuoteHomeConversionFactor = lossQuoteHomeConversionFactor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getFullVWAP() {
        return fullVWAP;
    }

    public void setFullVWAP(Double fullVWAP) {
        this.fullVWAP = fullVWAP;
    }

    public ClientPrice getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(ClientPrice fullPrice) {
        this.fullPrice = fullPrice;
    }

    public OrderFillReason getReason() {
        return reason;
    }

    public void setReason(OrderFillReason reason) {
        this.reason = reason;
    }

    public Double getPl() {
        return pl;
    }

    public void setPl(Double pl) {
        this.pl = pl;
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

    public Double getGuaranteedExecutionFee() {
        return guaranteedExecutionFee;
    }

    public void setGuaranteedExecutionFee(Double guaranteedExecutionFee) {
        this.guaranteedExecutionFee = guaranteedExecutionFee;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public TradeOpen getTradeOpened() {
        return tradeOpened;
    }

    public void setTradeOpened(TradeOpen tradeOpened) {
        this.tradeOpened = tradeOpened;
    }

    public TradeReduce[] getTradesClosed() {
        return tradesClosed;
    }

    public void setTradesClosed(TradeReduce[] tradesClosed) {
        this.tradesClosed = tradesClosed;
    }

    public TradeReduce getTradeReduced() {
        return tradeReduced;
    }

    public void setTradeReduced(TradeReduce tradeReduced) {
        this.tradeReduced = tradeReduced;
    }

    public Double getHalfSpreadCost() {
        return halfSpreadCost;
    }

    public void setHalfSpreadCost(Double halfSpreadCost) {
        this.halfSpreadCost = halfSpreadCost;
    }

}
