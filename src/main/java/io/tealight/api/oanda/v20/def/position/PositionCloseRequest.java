// This Java source file was generated on 2020-10-04 10:19:15 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.position;

import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;

public class PositionCloseRequest {
    private String longUnits = "ALL";
    private ClientExtensions longClientExtensions;
    private String shortUnits = "ALL";
    private ClientExtensions shortClientExtensions;

    public String getLongUnits() {
        return longUnits;
    }

    public void setLongUnits(String longUnits) {
        this.longUnits = longUnits;
    }

    public ClientExtensions getLongClientExtensions() {
        return longClientExtensions;
    }

    public void setLongClientExtensions(ClientExtensions longClientExtensions) {
        this.longClientExtensions = longClientExtensions;
    }

    public String getShortUnits() {
        return shortUnits;
    }

    public void setShortUnits(String shortUnits) {
        this.shortUnits = shortUnits;
    }

    public ClientExtensions getShortClientExtensions() {
        return shortClientExtensions;
    }

    public void setShortClientExtensions(ClientExtensions shortClientExtensions) {
        this.shortClientExtensions = shortClientExtensions;
    }

}
