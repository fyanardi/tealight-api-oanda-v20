package io.tealight.api.oanda.v20.endpoint.response.account;

import java.util.List;

import io.tealight.api.oanda.v20.def.primitive.Instrument;

public class AccountInstrumentsResponse {
    private List<Instrument> instruments;
    private String lastTransactionID;

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

}
