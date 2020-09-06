// This Java source file was generated on 2020-09-06 13:40:52 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.instrument;

import java.time.ZonedDateTime;

public class PositionBook {
    private String instrument;
    private ZonedDateTime time;
    private Double price;
    private Double bucketWidth;
    private PositionBookBucket[] buckets;

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBucketWidth() {
        return bucketWidth;
    }

    public void setBucketWidth(Double bucketWidth) {
        this.bucketWidth = bucketWidth;
    }

    public PositionBookBucket[] getBuckets() {
        return buckets;
    }

    public void setBuckets(PositionBookBucket[] buckets) {
        this.buckets = buckets;
    }

}
