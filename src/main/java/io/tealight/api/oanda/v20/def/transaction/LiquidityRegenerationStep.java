// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import java.time.ZonedDateTime;

public class LiquidityRegenerationStep {
    private ZonedDateTime timestamp;
    private Double bidLiquidityUsed;
    private Double askLiquidityUsed;

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getBidLiquidityUsed() {
        return bidLiquidityUsed;
    }

    public void setBidLiquidityUsed(Double bidLiquidityUsed) {
        this.bidLiquidityUsed = bidLiquidityUsed;
    }

    public Double getAskLiquidityUsed() {
        return askLiquidityUsed;
    }

    public void setAskLiquidityUsed(Double askLiquidityUsed) {
        this.askLiquidityUsed = askLiquidityUsed;
    }

}
