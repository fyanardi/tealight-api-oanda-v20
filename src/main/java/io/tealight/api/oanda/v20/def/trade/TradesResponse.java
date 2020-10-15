// This Java source file was generated on 2020-10-08 18:45:40 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

public class TradesResponse {
    private Trade[] trades;
    private String lastTransactionID;

    public Trade[] getTrades() {
        return trades;
    }

    public void setTrades(Trade[] trades) {
        this.trades = trades;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
