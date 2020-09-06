// This Java source file was generated on 2020-09-06 13:40:52 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.instrument;

import java.time.ZonedDateTime;

public class RawMarketPrice {
    private Integer liquidityPoolID;
    private String instrumentName;
    private String contractName;
    private ZonedDateTime timestamp;
    private PriceAdjustment[] adjustments;
    private RawMarketPriceDepthOfMarket orderBook;
    private RawMarketPriceDepthOfMarket ladder;

    public Integer getLiquidityPoolID() {
        return liquidityPoolID;
    }

    public void setLiquidityPoolID(Integer liquidityPoolID) {
        this.liquidityPoolID = liquidityPoolID;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public PriceAdjustment[] getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(PriceAdjustment[] adjustments) {
        this.adjustments = adjustments;
    }

    public RawMarketPriceDepthOfMarket getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(RawMarketPriceDepthOfMarket orderBook) {
        this.orderBook = orderBook;
    }

    public RawMarketPriceDepthOfMarket getLadder() {
        return ladder;
    }

    public void setLadder(RawMarketPriceDepthOfMarket ladder) {
        this.ladder = ladder;
    }

}
