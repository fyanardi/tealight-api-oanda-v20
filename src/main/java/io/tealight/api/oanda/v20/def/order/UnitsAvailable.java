// This Java source file was generated on 2020-10-04 14:26:11 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import com.google.gson.annotations.SerializedName;

public class UnitsAvailable {
    @SerializedName("default")
    private UnitsAvailableDetails _default;
    private UnitsAvailableDetails reduceFirst;
    private UnitsAvailableDetails reduceOnly;
    private UnitsAvailableDetails openOnly;

    public UnitsAvailableDetails getDefault() {
        return _default;
    }

    public void setDefault(UnitsAvailableDetails _default) {
        this._default = _default;
    }

    public UnitsAvailableDetails getReduceFirst() {
        return reduceFirst;
    }

    public void setReduceFirst(UnitsAvailableDetails reduceFirst) {
        this.reduceFirst = reduceFirst;
    }

    public UnitsAvailableDetails getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(UnitsAvailableDetails reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public UnitsAvailableDetails getOpenOnly() {
        return openOnly;
    }

    public void setOpenOnly(UnitsAvailableDetails openOnly) {
        this.openOnly = openOnly;
    }

}
