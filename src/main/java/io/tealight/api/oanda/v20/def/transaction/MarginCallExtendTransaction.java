// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;


public class MarginCallExtendTransaction extends Transaction {
    private TransactionType type = TransactionType.MARGIN_CALL_EXTEND;
    private Integer extensionNumber;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Integer getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(Integer extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

}
