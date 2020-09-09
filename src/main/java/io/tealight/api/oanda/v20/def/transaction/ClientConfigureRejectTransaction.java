// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

public class ClientConfigureRejectTransaction extends Transaction {
    private TransactionType type = TransactionType.CLIENT_CONFIGURE_REJECT;
    private String alias;
    private Double marginRate;
    private TransactionRejectReason rejectReason;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Double getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(Double marginRate) {
        this.marginRate = marginRate;
    }

    public TransactionRejectReason getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(TransactionRejectReason rejectReason) {
        this.rejectReason = rejectReason;
    }

}
