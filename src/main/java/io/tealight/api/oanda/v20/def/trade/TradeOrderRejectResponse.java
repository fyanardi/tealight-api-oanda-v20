// This Java source file was generated on 2020-10-08 18:45:40 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderCancelRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.StopLossOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossOrderRejectTransaction;

public class TradeOrderRejectResponse {
    private OrderCancelRejectTransaction takeProfitOrderCancelRejectTransaction;
    private TakeProfitOrderRejectTransaction takeProfitOrderRejectTransaction;
    private OrderCancelRejectTransaction stopLossOrderCancelRejectTransaction;
    private StopLossOrderRejectTransaction stopLossOrderRejectTransaction;
    private OrderCancelRejectTransaction trailingStopLossOrderCancelRejectTransaction;
    private TrailingStopLossOrderRejectTransaction trailingStopLossOrderRejectTransaction;
    private OrderCancelRejectTransaction guaranteedStopLossOrderCancelRejectTransaction;
    private GuaranteedStopLossOrderRejectTransaction guaranteedStopLossOrderRejectTransaction;
    private String lastTransactionID;
    private String[] relatedTransactionIDs;
    private String errorCode;
    private String errorMessage;

    public OrderCancelRejectTransaction getTakeProfitOrderCancelRejectTransaction() {
        return takeProfitOrderCancelRejectTransaction;
    }

    public void setTakeProfitOrderCancelRejectTransaction(OrderCancelRejectTransaction takeProfitOrderCancelRejectTransaction) {
        this.takeProfitOrderCancelRejectTransaction = takeProfitOrderCancelRejectTransaction;
    }

    public TakeProfitOrderRejectTransaction getTakeProfitOrderRejectTransaction() {
        return takeProfitOrderRejectTransaction;
    }

    public void setTakeProfitOrderRejectTransaction(TakeProfitOrderRejectTransaction takeProfitOrderRejectTransaction) {
        this.takeProfitOrderRejectTransaction = takeProfitOrderRejectTransaction;
    }

    public OrderCancelRejectTransaction getStopLossOrderCancelRejectTransaction() {
        return stopLossOrderCancelRejectTransaction;
    }

    public void setStopLossOrderCancelRejectTransaction(OrderCancelRejectTransaction stopLossOrderCancelRejectTransaction) {
        this.stopLossOrderCancelRejectTransaction = stopLossOrderCancelRejectTransaction;
    }

    public StopLossOrderRejectTransaction getStopLossOrderRejectTransaction() {
        return stopLossOrderRejectTransaction;
    }

    public void setStopLossOrderRejectTransaction(StopLossOrderRejectTransaction stopLossOrderRejectTransaction) {
        this.stopLossOrderRejectTransaction = stopLossOrderRejectTransaction;
    }

    public OrderCancelRejectTransaction getTrailingStopLossOrderCancelRejectTransaction() {
        return trailingStopLossOrderCancelRejectTransaction;
    }

    public void setTrailingStopLossOrderCancelRejectTransaction(OrderCancelRejectTransaction trailingStopLossOrderCancelRejectTransaction) {
        this.trailingStopLossOrderCancelRejectTransaction = trailingStopLossOrderCancelRejectTransaction;
    }

    public TrailingStopLossOrderRejectTransaction getTrailingStopLossOrderRejectTransaction() {
        return trailingStopLossOrderRejectTransaction;
    }

    public void setTrailingStopLossOrderRejectTransaction(TrailingStopLossOrderRejectTransaction trailingStopLossOrderRejectTransaction) {
        this.trailingStopLossOrderRejectTransaction = trailingStopLossOrderRejectTransaction;
    }

    public OrderCancelRejectTransaction getGuaranteedStopLossOrderCancelRejectTransaction() {
        return guaranteedStopLossOrderCancelRejectTransaction;
    }

    public void setGuaranteedStopLossOrderCancelRejectTransaction(OrderCancelRejectTransaction guaranteedStopLossOrderCancelRejectTransaction) {
        this.guaranteedStopLossOrderCancelRejectTransaction = guaranteedStopLossOrderCancelRejectTransaction;
    }

    public GuaranteedStopLossOrderRejectTransaction getGuaranteedStopLossOrderRejectTransaction() {
        return guaranteedStopLossOrderRejectTransaction;
    }

    public void setGuaranteedStopLossOrderRejectTransaction(GuaranteedStopLossOrderRejectTransaction guaranteedStopLossOrderRejectTransaction) {
        this.guaranteedStopLossOrderRejectTransaction = guaranteedStopLossOrderRejectTransaction;
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
