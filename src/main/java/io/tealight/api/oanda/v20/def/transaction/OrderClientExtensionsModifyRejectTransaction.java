// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;


public class OrderClientExtensionsModifyRejectTransaction extends Transaction {
    private TransactionType type = TransactionType.ORDER_CLIENT_EXTENSIONS_MODIFY_REJECT;
    private String orderID;
    private String clientOrderID;
    private ClientExtensions clientExtensionsModify;
    private ClientExtensions tradeClientExtensionsModify;
    private TransactionRejectReason rejectReason;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getClientOrderID() {
        return clientOrderID;
    }

    public void setClientOrderID(String clientOrderID) {
        this.clientOrderID = clientOrderID;
    }

    public ClientExtensions getClientExtensionsModify() {
        return clientExtensionsModify;
    }

    public void setClientExtensionsModify(ClientExtensions clientExtensionsModify) {
        this.clientExtensionsModify = clientExtensionsModify;
    }

    public ClientExtensions getTradeClientExtensionsModify() {
        return tradeClientExtensionsModify;
    }

    public void setTradeClientExtensionsModify(ClientExtensions tradeClientExtensionsModify) {
        this.tradeClientExtensionsModify = tradeClientExtensionsModify;
    }

    public TransactionRejectReason getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(TransactionRejectReason rejectReason) {
        this.rejectReason = rejectReason;
    }

}
