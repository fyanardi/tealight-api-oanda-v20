package io.tealight.api.oanda.v20.endpoint;

import java.lang.reflect.Field;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class FxTradeEndpointsUtils {

    /**
     * Link response header
     */
    public static final String LINK_RESPONSE_HEADER = "Link";

    /**
     * Regex to extract the URI from the link header value
     */
    public static final Pattern LINK_HEADER_VALUE_REGEX = Pattern.compile("^<(.*)>; *rel=\"(.*)\"$");

    /**
     * Build a map of query parameters (name, value) based on the fields of the passed in request
     * object
     *
     * @param request the POJO request object
     * @return a map of query parameters (name, value) of the request object
     */
    public static Map<String, String> queryFromQueryObject(Object request) {
        Map<String, String> query = new HashMap<>();

        for (Field field : request.getClass().getDeclaredFields()) {
            String name = field.getName();
            Class<?> type = field.getType();
            Object value = null;
            try {
                field.setAccessible(true);
                value = field.get(request);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }

            if (value != null) {
                // Convert to UTC-based ZonedDateTime
                if (type == ZonedDateTime.class) {
                    query.put(name, toUtcZonedDateTime((ZonedDateTime) value).toString());
                }
                else {
                    query.put(name, value.toString());
                }
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
