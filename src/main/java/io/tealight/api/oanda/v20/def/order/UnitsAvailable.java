// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;


public class UnitsAvailable {
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
