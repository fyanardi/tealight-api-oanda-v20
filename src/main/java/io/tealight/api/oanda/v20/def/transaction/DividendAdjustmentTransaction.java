// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;


public class DividendAdjustmentTransaction extends Transaction {
    private TransactionType type = TransactionType.DIVIDEND_ADJUSTMENT;
    private String instrument;
    private Double dividendAdjustment;
    private Double accountBalance;
    private OpenTradeDividendAdjustment[] openTradeDividendAdjustments;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Double getDividendAdjustment() {
        return dividendAdjustment;
    }

    public void setDividendAdjustment(Double dividendAdjustment) {
        this.dividendAdjustment = dividendAdjustment;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public OpenTradeDividendAdjustment[] getOpenTradeDividendAdjustments() {
        return openTradeDividendAdjustments;
    }

    public void setOpenTradeDividendAdjustments(OpenTradeDividendAdjustment[] openTradeDividendAdjustments) {
        this.openTradeDividendAdjustments = openTradeDividendAdjustments;
    }

}
