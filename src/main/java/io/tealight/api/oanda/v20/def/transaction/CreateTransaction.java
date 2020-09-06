// This Java source file was generated on 2020-09-06 13:40:49 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import java.util.Currency;

public class CreateTransaction extends Transaction {
    private TransactionType type = TransactionType.CREATE;
    private Integer divisionID;
    private Integer siteID;
    private Integer accountUserID;
    private Integer accountNumber;
    private Currency homeCurrency;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Integer getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Integer divisionID) {
        this.divisionID = divisionID;
    }

    public Integer getSiteID() {
        return siteID;
    }

    public void setSiteID(Integer siteID) {
        this.siteID = siteID;
    }

    public Integer getAccountUserID() {
        return accountUserID;
    }

    public void setAccountUserID(Integer accountUserID) {
        this.accountUserID = accountUserID;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Currency getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(Currency homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

}
