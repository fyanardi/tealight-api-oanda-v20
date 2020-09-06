// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import io.tealight.api.oanda.v20.def.account.AccountFinancingMode;

public class PositionFinancing {
    private String instrument;
    private Double financing;
    private OpenTradeFinancing[] openTradeFinancings;
    private AccountFinancingMode accountFinancingMode;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Double getFinancing() {
        return financing;
    }

    public void setFinancing(Double financing) {
        this.financing = financing;
    }

    public OpenTradeFinancing[] getOpenTradeFinancings() {
        return openTradeFinancings;
    }

    public void setOpenTradeFinancings(OpenTradeFinancing[] openTradeFinancings) {
        this.openTradeFinancings = openTradeFinancings;
    }

    public AccountFinancingMode getAccountFinancingMode() {
        return accountFinancingMode;
    }

    public void setAccountFinancingMode(AccountFinancingMode accountFinancingMode) {
        this.accountFinancingMode = accountFinancingMode;
    }

}
