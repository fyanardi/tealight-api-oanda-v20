package io.tealight.api.oanda.v20.adapter;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * GSON custom serializer/deserializer to serialize/deserialize Double values. When a double value is
 * deserialized, we want it to be Double, but when it is serialized OANDA server requires it to be
 * in String (i.e. within double quotes).
 * 
 * The following definitions that are mapped to Double are affected:
 * 'DecimalNumber', 'AccountUnits', 'PriceValue'.
 *
 * @author Fredy Yanardi
 *
 */
public class DoubleAdapter implements JsonDeserializer<Double>, JsonSerializer<Double> {

    @Override
    public JsonElement serialize(Double doubleValue, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(doubleValue.toString());
    }

    @Override
    public Double deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return Double.parseDouble(jsonElement.getAsString());
    }

}
