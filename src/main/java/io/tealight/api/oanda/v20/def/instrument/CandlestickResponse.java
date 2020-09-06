// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.instrument;


public class CandlestickResponse {
    private String instrument;
    private CandlestickGranularity granularity;
    private Candlestick[] candles;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public CandlestickGranularity getGranularity() {
        return granularity;
    }

    public void setGranularity(CandlestickGranularity granularity) {
        this.granularity = granularity;
    }

    public Candlestick[] getCandles() {
        return candles;
    }

    public void setCandles(Candlestick[] candles) {
        this.candles = candles;
    }

}
