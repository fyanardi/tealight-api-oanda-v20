// This Java source file was generated on 2020-10-08 18:45:41 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.TradeClientExtensionsModifyTransaction;

public class TradeUpdateClientExtensionsResponse {
    private TradeClientExtensionsModifyTransaction tradeClientExtensionsModifyTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;

    public TradeClientExtensionsModifyTransaction getTradeClientExtensionsModifyTransaction() {
        return tradeClientExtensionsModifyTransaction;
    }

    public void setTradeClientExtensionsModifyTransaction(TradeClientExtensionsModifyTransaction tradeClientExtensionsModifyTransaction) {
        this.tradeClientExtensionsModifyTransaction = tradeClientExtensionsModifyTransaction;
    }

    public String[] getRelatedTransactionIDs() {
        return relatedTransactionIDs;
    }

    public void setRelatedTransactionIDs(String[] relatedTransactionIDs) {
        this.relatedTransactionIDs = relatedTransactionIDs;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
