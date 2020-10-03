package io.tealight.api.oanda.v20.endpoint.query.instrument;

import java.time.ZonedDateTime;

import io.tealight.api.oanda.v20.def.instrument.CandlestickGranularity;
import io.tealight.api.oanda.v20.def.instrument.WeeklyAlignment;

public class CandlesQuery {

    /**
     * The Price component(s) to get candlestick data for. [default=M]
     * type: PricingComponent
     */
    private String price;

    /**
     * The granularity of the candlesticks to fetch [default=S5]
     * type: CandlestickGranularity
     */
    private CandlestickGranularity granularity;

    /**
     * The number of candlesticks to return in the response. Count should not be specified if both
     * the start and end parameters are provided, as the time range combined with the granularity
     * will determine the number of candlesticks to return. [default=500, maximum=5000]
     * type: integer
     */
    private Integer count; 

    /**
     * The start of the time range to fetch candlesticks for.
     * type: DateTime
     */
    private ZonedDateTime from;

    /**
     * The end of the time range to fetch candlesticks for.
     * type: DateTime
     */
    private ZonedDateTime to;

    /**
     * A flag that controls whether the candlestick is "smoothed" or not. A smoothed candlestick
     * uses the previous candle’s close price as its open price, while an un-smoothed candlestick
     * uses the first price from its time range as its open price. [default=False]
     * type: boolean
     */
    private Boolean smooth;

    /**
     * A flag that controls whether the candlestick that is covered by the from time should be
     * included in the results. This flag enables clients to use the timestamp of the last completed
     * candlestick received to poll for future candlesticks but avoid receiving the previous
     * candlestick repeatedly. [default=True]
     * type: boolean
     */
    private Boolean includeFirst;

    /**
     * The hour of the day (in the specified timezone) to use for granularities that have daily
     * alignments. [default=17, minimum=0, maximum=23]
     * type: integer
     */
    private Integer dailyAlignment;

    /**
     * The timezone to use for the dailyAlignment parameter. Candlesticks with daily alignment will
     * be aligned to the dailyAlignment hour within the alignmentTimezone. Note that the returned
     * times will still be represented in UTC. [default=America/New_York]
     * type: string
     */
    private String alignmentTimezone;

    /**
     * The day of the week used for granularities that have weekly alignment. [default=Friday]
     * type: WeeklyAlignment
     */
    private WeeklyAlignment weeklyAlignment;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CandlestickGranularity getGranularity() {
        return granularity;
    }

    public void setGranularity(CandlestickGranularity granularity) {
        this.granularity = granularity;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }

    public Boolean isSmooth() {
        return smooth;
    }

    public void setSmooth(Boolean smooth) {
        this.smooth = smooth;
    }

    public Boolean isIncludeFirst() {
        return includeFirst;
    }

    public void setIncludeFirst(Boolean includeFirst) {
        this.includeFirst = includeFirst;
    }

    public int getDailyAlignment() {
        return dailyAlignment;
    }

    public void setDailyAlignment(int dailyAlignment) {
        this.dailyAlignment = dailyAlignment;
    }

    public String getAlignmentTimezone() {
        return alignmentTimezone;
    }

    public void setAlignmentTimezone(String alignmentTimezone) {
        this.alignmentTimezone = alignmentTimezone;
    }

    public WeeklyAlignment getWeeklyAlignment() {
        return weeklyAlignment;
    }

    public void setWeeklyAlignment(WeeklyAlignment weeklyAlignment) {
        this.weeklyAlignment = weeklyAlignment;
    }

}
