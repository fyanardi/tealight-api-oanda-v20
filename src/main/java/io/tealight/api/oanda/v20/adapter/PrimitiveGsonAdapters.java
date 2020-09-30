package io.tealight.api.oanda.v20.adapter;

import java.time.ZonedDateTime;
import java.util.Currency;

import com.google.gson.GsonBuilder;

public class PrimitiveGsonAdapters {

    public static GsonBuilder newGsonBuilder() {
        return new GsonBuilder()
                .registerTypeAdapter(Double.class, new DoubleAdapter())
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
                .registerTypeAdapter(Currency.class, new CurrencyAdapter());
    }
}
