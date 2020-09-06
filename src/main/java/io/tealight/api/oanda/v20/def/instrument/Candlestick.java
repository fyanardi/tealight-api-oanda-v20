// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.instrument;

import java.time.ZonedDateTime;

public class Candlestick {
    private ZonedDateTime time;
    private CandlestickData bid;
    private CandlestickData ask;
    private CandlestickData mid;
    private Integer volume;
    private Boolean complete;

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public CandlestickData getBid() {
        return bid;
    }

    public void setBid(CandlestickData bid) {
        this.bid = bid;
    }

    public CandlestickData getAsk() {
        return ask;
    }

    public void setAsk(CandlestickData ask) {
        this.ask = ask;
    }

    public CandlestickData getMid() {
        return mid;
    }

    public void setMid(CandlestickData mid) {
        this.mid = mid;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

}
