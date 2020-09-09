// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

public class TradeClientExtensionsModifyTransaction extends Transaction {
    private TransactionType type = TransactionType.TRADE_CLIENT_EXTENSIONS_MODIFY;
    private String tradeID;
    private String clientTradeID;
    private ClientExtensions tradeClientExtensionsModify;

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

}
