// This Java source file was generated on 2020-10-08 18:45:40 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.trade;

import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderCancelTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderFillTransaction;
import io.tealight.api.oanda.v20.def.transaction.StopLossOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossOrderTransaction;

public class TradeOrderResponse {
    private OrderCancelTransaction takeProfitOrderCancelTransaction;
    private TakeProfitOrderTransaction takeProfitOrderTransaction;
    private OrderFillTransaction takeProfitOrderFillTransaction;
    private OrderCancelTransaction takeProfitOrderCreatedCancelTransaction;
    private OrderCancelTransaction stopLossOrderCancelTransaction;
    private StopLossOrderTransaction stopLossOrderTransaction;
    private OrderFillTransaction stopLossOrderFillTransaction;
    private OrderCancelTransaction stopLossOrderCreatedCancelTransaction;
    private OrderCancelTransaction trailingStopLossOrderCancelTransaction;
    private TrailingStopLossOrderTransaction trailingStopLossOrderTransaction;
    private OrderCancelTransaction guaranteedStopLossOrderCancelTransaction;
    private GuaranteedStopLossOrderTransaction guaranteedStopLossOrderTransaction;
    private String[] relatedTransactionIDs;
    private String lastTransactionID;

    public OrderCancelTransaction getTakeProfitOrderCancelTransaction() {
        return takeProfitOrderCancelTransaction;
    }

    public void setTakeProfitOrderCancelTransaction(OrderCancelTransaction takeProfitOrderCancelTransaction) {
        this.takeProfitOrderCancelTransaction = takeProfitOrderCancelTransaction;
    }

    public TakeProfitOrderTransaction getTakeProfitOrderTransaction() {
        return takeProfitOrderTransaction;
    }

    public void setTakeProfitOrderTransaction(TakeProfitOrderTransaction takeProfitOrderTransaction) {
        this.takeProfitOrderTransaction = takeProfitOrderTransaction;
    }

    public OrderFillTransaction getTakeProfitOrderFillTransaction() {
        return takeProfitOrderFillTransaction;
    }

    public void setTakeProfitOrderFillTransaction(OrderFillTransaction takeProfitOrderFillTransaction) {
        this.takeProfitOrderFillTransaction = takeProfitOrderFillTransaction;
    }

    public OrderCancelTransaction getTakeProfitOrderCreatedCancelTransaction() {
        return takeProfitOrderCreatedCancelTransaction;
    }

    public void setTakeProfitOrderCreatedCancelTransaction(OrderCancelTransaction takeProfitOrderCreatedCancelTransaction) {
        this.takeProfitOrderCreatedCancelTransaction = takeProfitOrderCreatedCancelTransaction;
    }

    public OrderCancelTransaction getStopLossOrderCancelTransaction() {
        return stopLossOrderCancelTransaction;
    }

    public void setStopLossOrderCancelTransaction(OrderCancelTransaction stopLossOrderCancelTransaction) {
        this.stopLossOrderCancelTransaction = stopLossOrderCancelTransaction;
    }

    public StopLossOrderTransaction getStopLossOrderTransaction() {
        return stopLossOrderTransaction;
    }

    public void setStopLossOrderTransaction(StopLossOrderTransaction stopLossOrderTransaction) {
        this.stopLossOrderTransaction = stopLossOrderTransaction;
    }

    public OrderFillTransaction getStopLossOrderFillTransaction() {
        return stopLossOrderFillTransaction;
    }

    public void setStopLossOrderFillTransaction(OrderFillTransaction stopLossOrderFillTransaction) {
        this.stopLossOrderFillTransaction = stopLossOrderFillTransaction;
    }

    public OrderCancelTransaction getStopLossOrderCreatedCancelTransaction() {
        return stopLossOrderCreatedCancelTransaction;
    }

    public void setStopLossOrderCreatedCancelTransaction(OrderCancelTransaction stopLossOrderCreatedCancelTransaction) {
        this.stopLossOrderCreatedCancelTransaction = stopLossOrderCreatedCancelTransaction;
    }

    public OrderCancelTransaction getTrailingStopLossOrderCancelTransaction() {
        return trailingStopLossOrderCancelTransaction;
    }

    public void setTrailingStopLossOrderCancelTransaction(OrderCancelTransaction trailingStopLossOrderCancelTransaction) {
        this.trailingStopLossOrderCancelTransaction = trailingStopLossOrderCancelTransaction;
    }

    public TrailingStopLossOrderTransaction getTrailingStopLossOrderTransaction() {
        return trailingStopLossOrderTransaction;
    }

    public void setTrailingStopLossOrderTransaction(TrailingStopLossOrderTransaction trailingStopLossOrderTransaction) {
        this.trailingStopLossOrderTransaction = trailingStopLossOrderTransaction;
    }

    public OrderCancelTransaction getGuaranteedStopLossOrderCancelTransaction() {
        return guaranteedStopLossOrderCancelTransaction;
    }

    public void setGuaranteedStopLossOrderCancelTransaction(OrderCancelTransaction guaranteedStopLossOrderCancelTransaction) {
        this.guaranteedStopLossOrderCancelTransaction = guaranteedStopLossOrderCancelTransaction;
    }

    public GuaranteedStopLossOrderTransaction getGuaranteedStopLossOrderTransaction() {
        return guaranteedStopLossOrderTransaction;
    }

    public void setGuaranteedStopLossOrderTransaction(GuaranteedStopLossOrderTransaction guaranteedStopLossOrderTransaction) {
        this.guaranteedStopLossOrderTransaction = guaranteedStopLossOrderTransaction;
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
