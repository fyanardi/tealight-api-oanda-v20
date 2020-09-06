// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;


public class DelayedTradeClosureTransaction extends Transaction {
    private TransactionType type = TransactionType.DELAYED_TRADE_CLOSURE;
    private MarketOrderReason reason;
    private String tradeIDs;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public MarketOrderReason getReason() {
        return reason;
    }

    public void setReason(MarketOrderReason reason) {
        this.reason = reason;
    }

    public String getTradeIDs() {
        return tradeIDs;
    }

    public void setTradeIDs(String tradeIDs) {
        this.tradeIDs = tradeIDs;
    }

}
