package io.tealight.api.oanda.v20.adapter;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * GSON custom type serializer/deserializer to serialize/deserialize datetime string in ISO8601 format
 * For example: 2020-08-26T02:28:30.860Z
 *
 * @author Fredy Yanardi
 *
 */
public class ZonedDateTimeAdapter implements JsonDeserializer<ZonedDateTime>,
        JsonSerializer<ZonedDateTime> {

    @Override
    public JsonElement serialize(ZonedDateTime zonedDateTime, Type type,
            JsonSerializationContext context) {
        return new JsonPrimitive(zonedDateTime.toString());
    }

    @Override
    public ZonedDateTime deserialize(JsonElement jsonElement, Type type,
            JsonDeserializationContext context) throws JsonParseException {
        try {
            return ZonedDateTime.parse(jsonElement.getAsString(),
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }
        catch (Exception e) {
            return null;
        }
    }

}
