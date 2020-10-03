// This Java source file was generated on 2020-10-03 10:25:48 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

import io.tealight.api.oanda.v20.def.primitive.Instrument;

public class AccountInstrumentsResponse {
    private Instrument[] instruments;
    private String lastTransactionID;

    public Instrument[] getInstruments() {
        return instruments;
    }

    public void setInstruments(Instrument[] instruments) {
        this.instruments = instruments;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
