// This Java source file was generated on 2020-10-08 18:45:40 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.TradeClientExtensionsModifyRejectTransaction;

public class TradeUpdateClientExtensionsRejectResponse {
    private TradeClientExtensionsModifyRejectTransaction tradeClientExtensionsModifyRejectTransaction;
    private String lastTransactionID;
    private String[] relatedTransactionIDs;
    private String errorCode;
    private String errorMessage;

    public TradeClientExtensionsModifyRejectTransaction getTradeClientExtensionsModifyRejectTransaction() {
        return tradeClientExtensionsModifyRejectTransaction;
    }

    public void setTradeClientExtensionsModifyRejectTransaction(TradeClientExtensionsModifyRejectTransaction tradeClientExtensionsModifyRejectTransaction) {
        this.tradeClientExtensionsModifyRejectTransaction = tradeClientExtensionsModifyRejectTransaction;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

    public String[] getRelatedTransactionIDs() {
        return relatedTransactionIDs;
    }

    public void setRelatedTransactionIDs(String[] relatedTransactionIDs) {
        this.relatedTransactionIDs = relatedTransactionIDs;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
