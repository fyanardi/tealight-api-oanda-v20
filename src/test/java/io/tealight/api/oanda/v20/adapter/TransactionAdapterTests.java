package io.tealight.api.oanda.v20.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.tealight.api.oanda.v20.def.order.OrderPositionFill;
import io.tealight.api.oanda.v20.def.order.TimeInForce;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderReason;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderFillReason;
import io.tealight.api.oanda.v20.def.transaction.OrderFillTransaction;
import io.tealight.api.oanda.v20.def.transaction.Transaction;
import io.tealight.api.oanda.v20.def.transaction.TransactionType;

/**
 * Test cases for TransactionAdapter (deserializer only adapter).
 *
 * TODO: more thorough test cases (the test cases here are only from the samples)
 *
 * @author Fredy Yanardi
 *
 */
public class TransactionAdapterTests {

    private static final String MARKET_TRANSACTION =
            "{" +
            "  \"accountID\": \"<ACCOUNT>\"," +
            "  \"batchID\": \"6409\"," +
            "  \"id\": \"6409\"," +
            "  \"instrument\": \"EUR_USD\"," +
            "  \"positionFill\": \"DEFAULT\"," +
            "  \"reason\": \"CLIENT_ORDER\"," +
            "  \"time\": \"2016-06-22T18:41:52.655959799Z\"," +
            "  \"timeInForce\": \"FOK\"," +
            "  \"type\": \"MARKET_ORDER\"," +
            "  \"units\": \"100\"," +
            "  \"userID\": 1001" +
            "}";

    private static final String ORDER_FILL_TRANSACTION =
            "{" +
            "  \"accountBalance\": \"43650.51319\"," +
            "  \"accountID\": \"<ACCOUNT>\"," +
            "  \"batchID\": \"6409\"," +
            "  \"financing\": \"0.00000\"," +
            "  \"id\": \"6410\"," +
            "  \"instrument\": \"EUR_USD\"," +
            "  \"orderID\": \"6409\"," +
            "  \"pl\": \"0.00000\"," +
            "  \"price\": \"1.13031\"," +
            "  \"reason\": \"MARKET_ORDER\"," +
            "  \"time\": \"2016-06-22T18:41:52.655959799Z\"," +
            "  \"tradeOpened\": {" +
            "    \"tradeID\": \"6410\"," +
            "    \"units\": \"100\"" +
            "  }," +
            "  \"type\": \"ORDER_FILL\"," +
            "  \"units\": \"100\"," +
            "  \"userID\": 1001" +
            "}";

    private Gson gson;

    @BeforeEach
    public void init() {
        GsonBuilder gsonBuilder = PrimitiveGsonAdapters.newGsonBuilder()
                .registerTypeAdapter(Transaction.class, new TransactionAdapter());
        gson = gsonBuilder.create();
    }

    @Test
    public void testMarketTransaction() {
        Transaction transaction = gson.fromJson(MARKET_TRANSACTION, Transaction.class);

        assertEquals(MarketOrderTransaction.class, transaction.getClass());

        MarketOrderTransaction marketOrderTxn = (MarketOrderTransaction) transaction;
        assertEquals("<ACCOUNT>", marketOrderTxn.getAccountID());
        assertEquals("6409", marketOrderTxn.getBatchID());
        assertEquals("6409", marketOrderTxn.getId());
        assertEquals("EUR_USD", marketOrderTxn.getInstrument());
        assertEquals(OrderPositionFill.DEFAULT, marketOrderTxn.getPositionFill());
        assertEquals(MarketOrderReason.CLIENT_ORDER, marketOrderTxn.getReason());
        assertEquals(ZonedDateTime.parse("2016-06-22T18:41:52.655959799Z"), marketOrderTxn.getTime()); 
        assertEquals(TimeInForce.FOK, marketOrderTxn.getTimeInForce());
        assertEquals(TransactionType.MARKET_ORDER, marketOrderTxn.getType());
        assertEquals(100, marketOrderTxn.getUnits());
        assertEquals(1001, marketOrderTxn.getUserID());
    }

    @Test
    public void testOrderFillTransaction() {
        Transaction transaction = gson.fromJson(ORDER_FILL_TRANSACTION, Transaction.class);

        assertEquals(OrderFillTransaction.class, transaction.getClass());

        OrderFillTransaction marketOrderTxn = (OrderFillTransaction) transaction;
        assertEquals(43650.51319, marketOrderTxn.getAccountBalance());
        assertEquals("<ACCOUNT>", marketOrderTxn.getAccountID());
        assertEquals("6409", marketOrderTxn.getBatchID());
        assertEquals(0.00000, marketOrderTxn.getFinancing());
        assertEquals("6410", marketOrderTxn.getId());
        assertEquals("EUR_USD", marketOrderTxn.getInstrument());
        assertEquals("6409", marketOrderTxn.getOrderID());
        assertEquals(0.00000, marketOrderTxn.getPl());
        assertEquals(1.13031, marketOrderTxn.getPrice());
        assertEquals(OrderFillReason.MARKET_ORDER, marketOrderTxn.getReason());
        assertEquals(ZonedDateTime.parse("2016-06-22T18:41:52.655959799Z"), marketOrderTxn.getTime());
        assertNotNull(marketOrderTxn.getTradeOpened());
        assertEquals("6410", marketOrderTxn.getTradeOpened().getTradeID());
        assertEquals(100, marketOrderTxn.getTradeOpened().getUnits());
        assertEquals(TransactionType.ORDER_FILL, marketOrderTxn.getType());
        assertEquals(100, marketOrderTxn.getUnits());
        assertEquals(1001, marketOrderTxn.getUserID());
    }
}
