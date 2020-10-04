// This Java source file was generated on 2020-10-04 10:19:15 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.position;

import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderRejectTransaction;

public class PositionCloseRejectResponse extends ErrorResponse {
    private MarketOrderRejectTransaction longOrderRejectTransaction;
    private MarketOrderRejectTransaction shortOrderRejectTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;
    private String errorCode;

    public MarketOrderRejectTransaction getLongOrderRejectTransaction() {
        return longOrderRejectTransaction;
    }

    public void setLongOrderRejectTransaction(MarketOrderRejectTransaction longOrderRejectTransaction) {
        this.longOrderRejectTransaction = longOrderRejectTransaction;
    }

    public MarketOrderRejectTransaction getShortOrderRejectTransaction() {
        return shortOrderRejectTransaction;
    }

    public void setShortOrderRejectTransaction(MarketOrderRejectTransaction shortOrderRejectTransaction) {
        this.shortOrderRejectTransaction = shortOrderRejectTransaction;
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
