// This Java source file was generated on 2020-10-08 18:45:40 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.StopLossDetails;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitDetails;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossDetails;

public class TradeOrderRequest {
    private TakeProfitDetails takeProfit;
    private StopLossDetails stopLoss;
    private TrailingStopLossDetails trailingStopLoss;
    private GuaranteedStopLossDetails guaranteedStopLoss;

    public TakeProfitDetails getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(TakeProfitDetails takeProfit) {
        this.takeProfit = takeProfit;
    }

    public StopLossDetails getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(StopLossDetails stopLoss) {
        this.stopLoss = stopLoss;
    }

    public TrailingStopLossDetails getTrailingStopLoss() {
        return trailingStopLoss;
    }

    public void setTrailingStopLoss(TrailingStopLossDetails trailingStopLoss) {
        this.trailingStopLoss = trailingStopLoss;
    }

    public GuaranteedStopLossDetails getGuaranteedStopLoss() {
        return guaranteedStopLoss;
    }

    public void setGuaranteedStopLoss(GuaranteedStopLossDetails guaranteedStopLoss) {
        this.guaranteedStopLoss = guaranteedStopLoss;
    }

}
