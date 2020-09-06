// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;


public class TradeClientExtensionsModifyRejectTransaction extends Transaction {
    private TransactionType type = TransactionType.TRADE_CLIENT_EXTENSIONS_MODIFY_REJECT;
    private String tradeID;
    private String clientTradeID;
    private ClientExtensions tradeClientExtensionsModify;
    private TransactionRejectReason rejectReason;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public String getClientTradeID() {
        return clientTradeID;
    }

    public void setClientTradeID(String clientTradeID) {
        this.clientTradeID = clientTradeID;
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
