// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.account.AccountFinancingMode;

public class DailyFinancingTransaction extends Transaction {
    private TransactionType type = TransactionType.DAILY_FINANCING;
    private Double financing;
    private Double accountBalance;
    private AccountFinancingMode accountFinancingMode;
    private PositionFinancing[] positionFinancings;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getFinancing() {
        return financing;
    }

    public void setFinancing(Double financing) {
        this.financing = financing;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public AccountFinancingMode getAccountFinancingMode() {
        return accountFinancingMode;
    }

    public void setAccountFinancingMode(AccountFinancingMode accountFinancingMode) {
        this.accountFinancingMode = accountFinancingMode;
    }

    public PositionFinancing[] getPositionFinancings() {
        return positionFinancings;
    }

    public void setPositionFinancings(PositionFinancing[] positionFinancings) {
        this.positionFinancings = positionFinancings;
    }

}
