// This Java source file was generated on 2020-10-04 14:26:11 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import com.google.gson.annotations.SerializedName;

public class UnitsAvailableDetails {
    @SerializedName("long")
    private Double _long;
    @SerializedName("short")
    private Double _short;

    public Double getLong() {
        return _long;
    }

    public void setLong(Double _long) {
        this._long = _long;
    }

    public Double getShort() {
        return _short;
    }

    public void setShort(Double _short) {
        this._short = _short;
    }

}
