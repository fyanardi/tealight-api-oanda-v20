// This Java source file was generated on 2020-09-11 14:55:02 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.transaction;

public class TransactionsResponse {
    private Transaction[] transactions;
    private String lastTransactionID;

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
