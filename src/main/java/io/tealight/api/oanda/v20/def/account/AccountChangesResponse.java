// This Java source file was generated on 2020-10-03 10:25:47 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.account;

public class AccountChangesResponse {
    private AccountChanges changes;
    private AccountChangesState state;
    private String lastTransactionID;

    public AccountChanges getChanges() {
        return changes;
    }

    public void setChanges(AccountChanges changes) {
        this.changes = changes;
    }

    public AccountChangesState getState() {
        return state;
    }

    public void setState(AccountChangesState state) {
        this.state = state;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
