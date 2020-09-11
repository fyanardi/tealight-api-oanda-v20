package io.tealight.api.oanda.v20.adapter;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import io.tealight.api.oanda.v20.def.order.FixedPriceOrder;
import io.tealight.api.oanda.v20.def.order.GuaranteedStopLossOrder;
import io.tealight.api.oanda.v20.def.order.LimitOrder;
import io.tealight.api.oanda.v20.def.order.MarketIfTouchedOrder;
import io.tealight.api.oanda.v20.def.order.MarketOrder;
import io.tealight.api.oanda.v20.def.order.Order;
import io.tealight.api.oanda.v20.def.order.OrderType;
import io.tealight.api.oanda.v20.def.order.StopLossOrder;
import io.tealight.api.oanda.v20.def.order.StopOrder;
import io.tealight.api.oanda.v20.def.order.TakeProfitOrder;
import io.tealight.api.oanda.v20.def.order.TrailingStopLossOrder;

/**
 * GSON custom deserializer to deserialize an order json object into specific Order subclass
 * instance.
 *
 * @author Fredy Yanardi
 *
 */
public class OrderAdapter implements JsonDeserializer<Order> {

    private Gson gson;

    @Override
    public Order deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            throw new JsonParseException("Order must be a JSON object");
        }

        if (!jsonElement.getAsJsonObject().has("type")) {
            return getJson().fromJson(jsonElement, Order.class);
        }

        String typeString = jsonElement.getAsJsonObject().get("type").getAsString();
        OrderType orderType = OrderType.valueOf(typeString);
        if (orderType == null) {
            return getJson().fromJson(jsonElement, Order.class);
        }

        switch (orderType) {
        case FIXED_PRICE:
            return getJson().fromJson(jsonElement, FixedPriceOrder.class);
        case GUARANTEED_STOP_LOSS:
            return getJson().fromJson(jsonElement, GuaranteedStopLossOrder.class);
        case LIMIT:
            return getJson().fromJson(jsonElement, LimitOrder.class);
        case MARKET:
            return getJson().fromJson(jsonElement, MarketOrder.class);
        case MARKET_IF_TOUCHED:
            return getJson().fromJson(jsonElement, MarketIfTouchedOrder.class);
        case STOP:
            return getJson().fromJson(jsonElement, StopOrder.class);
        case STOP_LOSS:
            return getJson().fromJson(jsonElement, StopLossOrder.class);
        case TAKE_PROFIT:
            return getJson().fromJson(jsonElement, TakeProfitOrder.class);
        case TRAILING_STOP_LOSS:
            return getJson().fromJson(jsonElement, TrailingStopLossOrder.class);
        default:
            // Should never happen
            return getJson().fromJson(jsonElement, Order.class);
        }
    }

    private Gson getJson() {
        if (gson == null) {
            gson = PrimitiveGsonAdapters.newGsonBuilder().create();
        }
        return gson;
    }
}
