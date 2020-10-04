// This Java source file was generated on 2020-10-04 10:19:15 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.position;

public class PositionsResponse {
    private Position[] positions;
    private String lastTransactionID;

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

}
