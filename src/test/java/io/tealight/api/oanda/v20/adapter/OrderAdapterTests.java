package io.tealight.api.oanda.v20.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.tealight.api.oanda.v20.def.order.LimitOrder;
import io.tealight.api.oanda.v20.def.order.MarketIfTouchedOrder;
import io.tealight.api.oanda.v20.def.order.Order;
import io.tealight.api.oanda.v20.def.order.OrderPositionFill;
import io.tealight.api.oanda.v20.def.order.OrderState;
import io.tealight.api.oanda.v20.def.order.OrderTriggerCondition;
import io.tealight.api.oanda.v20.def.order.OrderType;
import io.tealight.api.oanda.v20.def.order.TakeProfitOrder;
import io.tealight.api.oanda.v20.def.order.TimeInForce;

/**
 * Test cases for OrderAdapter (deserializer only adapter).
 *
 * TODO: more thorough test cases (the test cases here are only from the samples)
 *
 * @author Fredy Yanardi
 *
 */
public class OrderAdapterTests {

    private static final String MARKET_IF_TOUCHED_ORDER = 
            "{" + 
            "  \"clientExtensions\": {" + 
            "    \"comment\": \"New idea for trading\"," + 
            "    \"id\": \"my_order_100\"," + 
            "    \"tag\": \"strategy_9\"" + 
            "  }," + 
            "  \"createTime\": \"2016-06-22T18:41:29.294265338Z\"," + 
            "  \"id\": \"6375\"," + 
            "  \"instrument\": \"EUR_CAD\"," + 
            "  \"partialFill\": \"DEFAULT_FILL\"," + 
            "  \"positionFill\": \"DEFAULT\"," + 
            "  \"price\": \"1.30000\"," + 
            "  \"replacesOrderID\": \"6373\"," + 
            "  \"state\": \"PENDING\"," + 
            "  \"timeInForce\": \"GTC\"," + 
            "  \"triggerCondition\": \"DEFAULT\"," + 
            "  \"type\": \"MARKET_IF_TOUCHED\"," + 
            "  \"units\": \"10000\"" + 
            "}";

    private static final String LIMIT_ORDER =
            "{" + 
            "  \"createTime\": \"2016-06-22T18:41:29.285982286Z\"," + 
            "  \"id\": \"6372\"," + 
            "  \"instrument\": \"USD_CAD\"," + 
            "  \"partialFill\": \"DEFAULT_FILL\"," + 
            "  \"positionFill\": \"DEFAULT\"," + 
            "  \"price\": \"1.50000\"," + 
            "  \"state\": \"PENDING\"," + 
            "  \"stopLossOnFill\": {" + 
            "    \"price\": \"1.70000\"," + 
            "    \"timeInForce\": \"GTC\"" + 
            "  }," + 
            "  \"timeInForce\": \"GTC\"," + 
            "  \"triggerCondition\": \"DEFAULT\"," + 
            "  \"type\": \"LIMIT\"," + 
            "  \"units\": \"-1000\"" + 
            "}";

    private static final String TAKE_PROFIT_ORDER =
            "{" + 
            "  \"createTime\": \"2016-06-22T18:41:29.281617221Z\"," + 
            "  \"id\": \"6371\"," + 
            "  \"price\": \"1.70000\"," + 
            "  \"replacesOrderID\": \"6369\"," + 
            "  \"state\": \"PENDING\"," + 
            "  \"timeInForce\": \"GTC\"," + 
            "  \"tradeID\": \"6368\"," + 
            "  \"triggerCondition\": \"DEFAULT\"," + 
            "  \"type\": \"TAKE_PROFIT\"" + 
            "}";

    private Gson gson;

    @BeforeEach
    public void init() {
        GsonBuilder gsonBuilder = PrimitiveGsonAdapters.newGsonBuilder()
                .registerTypeAdapter(Order.class, new OrderAdapter());
        gson = gsonBuilder.create();
    }

    @Test
    public void testMarketIfTouchedOrder() {
        Order order = gson.fromJson(MARKET_IF_TOUCHED_ORDER, Order.class);

        assertEquals(MarketIfTouchedOrder.class, order.getClass());

        MarketIfTouchedOrder mitOrder = (MarketIfTouchedOrder) order;
        assertNotNull(mitOrder.getClientExtensions());
        assertEquals("New idea for trading", mitOrder.getClientExtensions().getComment());
        assertEquals("my_order_100", mitOrder.getClientExtensions().getId());
        assertEquals("strategy_9", mitOrder.getClientExtensions().getTag()); 
        // This is not in the published schema
        // "partialFill": "DEFAULT_FILL"
        assertEquals(ZonedDateTime.parse("2016-06-22T18:41:29.294265338Z"), mitOrder.getCreateTime());
        assertEquals("6375", mitOrder.getId());
        assertEquals("EUR_CAD", mitOrder.getInstrument());
        assertEquals(OrderPositionFill.DEFAULT, mitOrder.getPositionFill());
        assertEquals(1.30000, mitOrder.getPrice());
        assertEquals("6373", mitOrder.getReplacesOrderID());
        assertEquals(OrderState.PENDING, mitOrder.getState());
        assertEquals(TimeInForce.GTC, mitOrder.getTimeInForce()); 
        assertEquals(OrderTriggerCondition.DEFAULT, mitOrder.getTriggerCondition());
        assertEquals(OrderType.MARKET_IF_TOUCHED, mitOrder.getType()); 
        assertEquals(10000, mitOrder.getUnits());
    }

    @Test
    public void testLimitOrder() {
        Order order = gson.fromJson(LIMIT_ORDER, Order.class);

        assertEquals(LimitOrder.class, order.getClass());

        LimitOrder limitOrder = (LimitOrder) order;
        assertEquals(ZonedDateTime.parse("2016-06-22T18:41:29.285982286Z"),
                limitOrder.getCreateTime());
        assertEquals("6372", limitOrder.getId());
        assertEquals("USD_CAD", limitOrder.getInstrument());
        assertEquals(OrderPositionFill.DEFAULT, limitOrder.getPositionFill());
        assertEquals(1.50000, limitOrder.getPrice());
        assertEquals(OrderState.PENDING, limitOrder.getState());
        assertNotNull(limitOrder.getStopLossOnFill());
        assertEquals(1.70000, limitOrder.getStopLossOnFill().getPrice());
        assertEquals(TimeInForce.GTC, limitOrder.getStopLossOnFill().getTimeInForce());
        assertEquals(TimeInForce.GTC, limitOrder.getTimeInForce());
        assertEquals(OrderTriggerCondition.DEFAULT, limitOrder.getTriggerCondition());
        assertEquals(OrderType.LIMIT, limitOrder.getType());
        assertEquals(-1000, limitOrder.getUnits());
    }

    @Test
    public void testTakeProfitOrder() {
        Order order = gson.fromJson(TAKE_PROFIT_ORDER, Order.class);

        assertEquals(TakeProfitOrder.class, order.getClass());

        TakeProfitOrder tpOrder = (TakeProfitOrder) order;
        assertEquals(ZonedDateTime.parse("2016-06-22T18:41:29.281617221Z"), tpOrder.getCreateTime());
        assertEquals("6371", tpOrder.getId());
        assertEquals(1.70000, tpOrder.getPrice());
        assertEquals("6369", tpOrder.getReplacesOrderID());
        assertEquals(OrderState.PENDING, tpOrder.getState());
        assertEquals(TimeInForce.GTC, tpOrder.getTimeInForce());
        assertEquals("6368", tpOrder.getTradeID());
        assertEquals(OrderTriggerCondition.DEFAULT, tpOrder.getTriggerCondition());
        assertEquals(OrderType.TAKE_PROFIT, tpOrder.getType());
    }
}
