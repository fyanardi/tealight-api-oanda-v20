// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.position;

public class CalculatedPositionState {
    private String instrument;
    private Double netUnrealizedPL;
    private Double longUnrealizedPL;
    private Double shortUnrealizedPL;
    private Double marginUsed;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Double getNetUnrealizedPL() {
        return netUnrealizedPL;
    }

    public void setNetUnrealizedPL(Double netUnrealizedPL) {
        this.netUnrealizedPL = netUnrealizedPL;
    }

    public Double getLongUnrealizedPL() {
        return longUnrealizedPL;
    }

    public void setLongUnrealizedPL(Double longUnrealizedPL) {
        this.longUnrealizedPL = longUnrealizedPL;
    }

    public Double getShortUnrealizedPL() {
        return shortUnrealizedPL;
    }

    public void setShortUnrealizedPL(Double shortUnrealizedPL) {
        this.shortUnrealizedPL = shortUnrealizedPL;
    }

    public Double getMarginUsed() {
        return marginUsed;
    }

    public void setMarginUsed(Double marginUsed) {
        this.marginUsed = marginUsed;
    }

}
