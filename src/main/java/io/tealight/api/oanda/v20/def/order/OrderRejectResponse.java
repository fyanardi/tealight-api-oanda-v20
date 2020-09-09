// This Java source file was generated on 2020-09-09 10:23:45 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.ErrorResponse;

public class OrderRejectResponse extends ErrorResponse {
    private String[] relatedTransactionIDs;
    private String lastTransactionID;
    private String errorCode;

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
