package io.tealight.api.oanda.v20.adapter;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import io.tealight.api.oanda.v20.def.transaction.ClientConfigureRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.ClientConfigureTransaction;
import io.tealight.api.oanda.v20.def.transaction.CloseTransaction;
import io.tealight.api.oanda.v20.def.transaction.CreateTransaction;
import io.tealight.api.oanda.v20.def.transaction.DailyFinancingTransaction;
import io.tealight.api.oanda.v20.def.transaction.DelayedTradeClosureTransaction;
import io.tealight.api.oanda.v20.def.transaction.DividendAdjustmentTransaction;
import io.tealight.api.oanda.v20.def.transaction.FixedPriceOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.GuaranteedStopLossOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.LimitOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.LimitOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.MarginCallEnterTransaction;
import io.tealight.api.oanda.v20.def.transaction.MarginCallExitTransaction;
import io.tealight.api.oanda.v20.def.transaction.MarginCallExtendTransaction;
import io.tealight.api.oanda.v20.def.transaction.MarketIfTouchedOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.MarketIfTouchedOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.MarketOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderCancelRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderCancelTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderClientExtensionsModifyRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderClientExtensionsModifyTransaction;
import io.tealight.api.oanda.v20.def.transaction.OrderFillTransaction;
import io.tealight.api.oanda.v20.def.transaction.ReopenTransaction;
import io.tealight.api.oanda.v20.def.transaction.ResetResettablePLTransaction;
import io.tealight.api.oanda.v20.def.transaction.StopLossOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.StopLossOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.StopOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.StopOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.TakeProfitOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.TradeClientExtensionsModifyRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.TradeClientExtensionsModifyTransaction;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossOrderRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.TrailingStopLossOrderTransaction;
import io.tealight.api.oanda.v20.def.transaction.Transaction;
import io.tealight.api.oanda.v20.def.transaction.TransactionType;
import io.tealight.api.oanda.v20.def.transaction.TransferFundsRejectTransaction;
import io.tealight.api.oanda.v20.def.transaction.TransferFundsTransaction;

/**
 * GSON custom deserializer to deserialize a transaction json object into specific Transaction
 * subclass instance
 *
 * @author Fredy Yanardi
 *
 */
public class TransactionAdapter implements JsonDeserializer<Transaction> {

    private Gson gson;

    @Override
    public Transaction deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            throw new JsonParseException("Transaction must be a JSON object");
        }

        if (!jsonElement.getAsJsonObject().has("type")) {
            return getJson().fromJson(jsonElement, Transaction.class);
        }

        String typeString = jsonElement.getAsJsonObject().get("type").getAsString();
        TransactionType orderType = TransactionType.valueOf(typeString);
        if (orderType == null) {
            return getJson().fromJson(jsonElement, Transaction.class);
        }

        switch (orderType) {
        case CLIENT_CONFIGURE:
            return getJson().fromJson(jsonElement, ClientConfigureTransaction.class);
        case CLIENT_CONFIGURE_REJECT:
            return getJson().fromJson(jsonElement, ClientConfigureRejectTransaction.class);
        case CLOSE:
            return getJson().fromJson(jsonElement, CloseTransaction.class);
        case CREATE:
            return getJson().fromJson(jsonElement, CreateTransaction.class);
        case DAILY_FINANCING:
            return getJson().fromJson(jsonElement, DailyFinancingTransaction.class);
        case DELAYED_TRADE_CLOSURE:
            return getJson().fromJson(jsonElement, DelayedTradeClosureTransaction.class);
        case DIVIDEND_ADJUSTMENT:
            return getJson().fromJson(jsonElement, DividendAdjustmentTransaction.class);
        case FIXED_PRICE_ORDER:
            return getJson().fromJson(jsonElement, FixedPriceOrderTransaction.class);
        case GUARANTEED_STOP_LOSS_ORDER:
            return getJson().fromJson(jsonElement, GuaranteedStopLossOrderTransaction.class);
        case GUARANTEED_STOP_LOSS_ORDER_REJECT:
            return getJson().fromJson(jsonElement, GuaranteedStopLossOrderRejectTransaction.class);
        case LIMIT_ORDER:
            return getJson().fromJson(jsonElement, LimitOrderTransaction.class);
        case LIMIT_ORDER_REJECT:
            return getJson().fromJson(jsonElement, LimitOrderRejectTransaction.class);
        case MARGIN_CALL_ENTER:
            return getJson().fromJson(jsonElement, MarginCallEnterTransaction.class);
        case MARGIN_CALL_EXIT:
            return getJson().fromJson(jsonElement, MarginCallExitTransaction.class);
        case MARGIN_CALL_EXTEND:
            return getJson().fromJson(jsonElement, MarginCallExtendTransaction.class);
        case MARKET_IF_TOUCHED_ORDER:
            return getJson().fromJson(jsonElement, MarketIfTouchedOrderTransaction.class);
        case MARKET_IF_TOUCHED_ORDER_REJECT:
            return getJson().fromJson(jsonElement, MarketIfTouchedOrderRejectTransaction.class);
        case MARKET_ORDER:
            return getJson().fromJson(jsonElement, MarketOrderTransaction.class);
        case MARKET_ORDER_REJECT:
            return getJson().fromJson(jsonElement, MarketOrderRejectTransaction.class);
        case ORDER_CANCEL:
            return getJson().fromJson(jsonElement, OrderCancelTransaction.class);
        case ORDER_CANCEL_REJECT:
            return getJson().fromJson(jsonElement, OrderCancelRejectTransaction.class);
        case ORDER_CLIENT_EXTENSIONS_MODIFY:
            return getJson().fromJson(jsonElement, OrderClientExtensionsModifyTransaction.class);
        case ORDER_CLIENT_EXTENSIONS_MODIFY_REJECT:
            return getJson().fromJson(jsonElement, OrderClientExtensionsModifyRejectTransaction.class);
        case ORDER_FILL:
            return getJson().fromJson(jsonElement, OrderFillTransaction.class);
        case REOPEN:
            return getJson().fromJson(jsonElement, ReopenTransaction.class);
        case RESET_RESETTABLE_PL:
            return getJson().fromJson(jsonElement, ResetResettablePLTransaction.class);
        case STOP_LOSS_ORDER:
            return getJson().fromJson(jsonElement, StopLossOrderTransaction.class);
        case STOP_LOSS_ORDER_REJECT:
            return getJson().fromJson(jsonElement, StopLossOrderRejectTransaction.class);
        case STOP_ORDER:
            return getJson().fromJson(jsonElement, StopOrderTransaction.class);
        case STOP_ORDER_REJECT:
            return getJson().fromJson(jsonElement, StopOrderRejectTransaction.class);
        case TAKE_PROFIT_ORDER:
            return getJson().fromJson(jsonElement, TakeProfitOrderTransaction.class);
        case TAKE_PROFIT_ORDER_REJECT:
            return getJson().fromJson(jsonElement, TakeProfitOrderRejectTransaction.class);
        case TRADE_CLIENT_EXTENSIONS_MODIFY:
            return getJson().fromJson(jsonElement, TradeClientExtensionsModifyTransaction.class);
        case TRADE_CLIENT_EXTENSIONS_MODIFY_REJECT:
            return getJson().fromJson(jsonElement, TradeClientExtensionsModifyRejectTransaction.class);
        case TRAILING_STOP_LOSS_ORDER:
            return getJson().fromJson(jsonElement, TrailingStopLossOrderTransaction.class);
        case TRAILING_STOP_LOSS_ORDER_REJECT:
            return getJson().fromJson(jsonElement, TrailingStopLossOrderRejectTransaction.class);
        case TRANSFER_FUNDS:
            return getJson().fromJson(jsonElement, TransferFundsTransaction.class);
        case TRANSFER_FUNDS_REJECT:
            return getJson().fromJson(jsonElement, TransferFundsRejectTransaction.class);
        default:
            // Should never happen
            return getJson().fromJson(jsonElement, Transaction.class);
        }
    }

    private Gson getJson() {
        if (gson == null) {
            gson = PrimitiveGsonAdapters.newGsonBuilder().create();
        }
        return gson;
    }
}
