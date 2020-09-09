// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

public class TransferFundsTransaction extends Transaction {
    private TransactionType type = TransactionType.TRANSFER_FUNDS;
    private Double amount;
    private FundingReason fundingReason;
    private String comment;
    private Double accountBalance;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public FundingReason getFundingReason() {
        return fundingReason;
    }

    public void setFundingReason(FundingReason fundingReason) {
        this.fundingReason = fundingReason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

}
