// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.pricing;

import io.tealight.api.oanda.v20.def.order.UnitsAvailable;
import io.tealight.api.oanda.v20.def.pricing.common.PriceBucket;
import java.time.ZonedDateTime;

public class ClientPrice {
    private String type = "PRICE";
    private String instrument;
    private ZonedDateTime time;
    private PriceStatus status;
    private Boolean tradeable;
    private PriceBucket[] bids;
    private PriceBucket[] asks;
    private Double closeoutBid;
    private Double closeoutAsk;
    private QuoteHomeConversionFactors quoteHomeConversionFactors;
    private UnitsAvailable unitsAvailable;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public PriceStatus getStatus() {
        return status;
    }

    public void setStatus(PriceStatus status) {
        this.status = status;
    }

    public Boolean getTradeable() {
        return tradeable;
    }

    public void setTradeable(Boolean tradeable) {
        this.tradeable = tradeable;
    }

    public PriceBucket[] getBids() {
        return bids;
    }

    public void setBids(PriceBucket[] bids) {
        this.bids = bids;
    }

    public PriceBucket[] getAsks() {
        return asks;
    }

    public void setAsks(PriceBucket[] asks) {
        this.asks = asks;
    }

    public Double getCloseoutBid() {
        return closeoutBid;
    }

    public void setCloseoutBid(Double closeoutBid) {
        this.closeoutBid = closeoutBid;
    }

    public Double getCloseoutAsk() {
        return closeoutAsk;
    }

    public void setCloseoutAsk(Double closeoutAsk) {
        this.closeoutAsk = closeoutAsk;
    }

    public QuoteHomeConversionFactors getQuoteHomeConversionFactors() {
        return quoteHomeConversionFactors;
    }

    public void setQuoteHomeConversionFactors(QuoteHomeConversionFactors quoteHomeConversionFactors) {
        this.quoteHomeConversionFactors = quoteHomeConversionFactors;
    }

    public UnitsAvailable getUnitsAvailable() {
        return unitsAvailable;
    }

    public void setUnitsAvailable(UnitsAvailable unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
    }

}
