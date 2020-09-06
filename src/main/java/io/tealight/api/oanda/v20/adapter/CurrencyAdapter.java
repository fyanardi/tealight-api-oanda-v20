package io.tealight.api.oanda.v20.adapter;

import java.lang.reflect.Type;
import java.util.Currency;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * GSON custom serializer/deserializer to serialize/deserialize currency string in ISO 4217 format
 * For example: "CHF"
 *
 * Java built-in java.util.Currency class is used
 *
 * @author Fredy Yanardi
 *
 */
public class CurrencyAdapter implements JsonDeserializer<Currency>, JsonSerializer<Currency> {

    @Override
    public JsonElement serialize(Currency currency, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(currency.toString());
    }

    @Override
    public Currency deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return Currency.getInstance(jsonElement.getAsString());
    }

}
