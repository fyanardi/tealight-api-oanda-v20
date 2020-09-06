package io.tealight.api.oanda.v20.endpoint;

import java.lang.reflect.Field;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class FxTradeEndpointsUtils {

    /**
     * Build a map of query parameters (name, value) based on the fields of the passed in request
     * object
     *
     * @param request the POJO request object
     * @return a map of query parameters (name, value) of the request object
     */
    public static Map<String, String> queryFromRequestObject(Object request) {
        Map<String, String> query = new HashMap<>();

        for (Field field : request.getClass().getDeclaredFields()) {
            String name = field.getName();
            Object value = null;
            try {
                field.setAccessible(true);
                value = field.get(request);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }

            if (value != null) {
                query.put(name, value.toString());
            }
        }

        return query;
    }

    /**
     * Return a ZonedDateTime instance in UTC zone and truncate it to SECONDS unit
     *
     * @param time a ZonedDateTime instance
     * @return a ZonedDateTime instance in UTC zone and truncate it to SECONDS unit
     */
    public static ZonedDateTime toUtcZonedDateTime(ZonedDateTime time) {
        ZoneId utcZoneId = ZoneId.ofOffset("", ZoneOffset.UTC);
        return time.withZoneSameInstant(utcZoneId).truncatedTo(ChronoUnit.SECONDS);
    }
}
