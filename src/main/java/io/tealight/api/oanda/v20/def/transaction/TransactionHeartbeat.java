// This Java source file was generated on 2020-09-06 13:40:50 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

import java.time.ZonedDateTime;

public class TransactionHeartbeat {
    private String type = "HEARTBEAT";
    private String lastTransactionID;
    private ZonedDateTime time;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

}
