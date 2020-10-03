package io.tealight.api.oanda.v20.sample;

import java.io.IOException;

import com.google.gson.Gson;

import io.tealight.api.oanda.v20.FxTradeType;
import io.tealight.api.oanda.v20.OandaV20Api;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.account.AccountsResponse;
import io.tealight.api.oanda.v20.def.order.ClientExtensionsRequest;
import io.tealight.api.oanda.v20.def.order.ClientExtensionsResponse;
import io.tealight.api.oanda.v20.def.order.LimitOrderRequest;
import io.tealight.api.oanda.v20.def.order.Order;
import io.tealight.api.oanda.v20.def.order.OrderResponse;
import io.tealight.api.oanda.v20.def.order.OrderStateFilter;
import io.tealight.api.oanda.v20.def.transaction.ClientExtensions;
import io.tealight.api.oanda.v20.endpoint.AccountEndpoints;
import io.tealight.api.oanda.v20.endpoint.OrderEndpoints;
import io.tealight.api.oanda.v20.endpoint.request.order.OrdersRequest;
import io.tealight.api.oanda.v20.endpoint.response.order.OrdersResponse;
import io.tealight.api.oanda.v20.exception.FxTradeException;

/**
 * Sample code on how to invoke OrderEndpoints APIs
 *
 * @author Fredy Yanardi
 *
 */
public class OrderSample {

    private static final FxTradeType FX_TRADE_TYPE = FxTradeType.FX_TRADE_PRACTICE;

    public static void main(String[] args) {
        String oandaToken = System.getenv("OANDA_TOKEN");

        Gson gson = PrimitiveGsonAdapters.newGsonBuilder().setPrettyPrinting().create();

        OandaV20Api oandaV20Api = new OandaV20Api(FX_TRADE_TYPE, oandaToken);
        OrderEndpoints orderEndpoints = oandaV20Api.getOrderEndpoints();

        AccountEndpoints accountEndpoints = oandaV20Api.getAccountEndpoints();

        try {
            AccountsResponse accounts = accountEndpoints.getAccounts();
            if (accounts.getAccounts().length == 0) {
                System.err.println("No account information available");
                return;
            }

            String accountId = accounts.getAccounts()[0].getId();

            System.out.println("+++++ Create order +++++");
            // Limit order 1000 units of EUR/USD @1.1000
            LimitOrderRequest limitOrderRequest = new LimitOrderRequest();
            limitOrderRequest.setInstrument("EUR_USD");
            limitOrderRequest.setUnits(1000.0);
            limitOrderRequest.setPrice(1.1000);

            OrderResponse orderResponse = orderEndpoints.createOrder(accountId, limitOrderRequest);
            System.out.println("Replace order response:");
            System.out.println(gson.toJson(orderResponse));
            System.out.println();

            // Newly created order id
            String newOrderId = orderResponse.getOrderCreateTransaction().getId();

            // Get all orders with state "FILLED"
            System.out.println("+++++ Get orders with state 'FILLED' +++++");
            OrdersRequest ordersRequest = new OrdersRequest();
            ordersRequest.setState(OrderStateFilter.FILLED);

            System.out.println("Get orders response");
            OrdersResponse orders = orderEndpoints.getOrders(accountId, ordersRequest);
            System.out.println(gson.toJson(orders));
            System.out.println();

            System.out.println("+++++ Get pending order +++++");
            OrdersResponse pendingOrders = orderEndpoints.getPendingOrders(accountId);

            System.out.println("Get pending order response");
            System.out.println(gson.toJson(pendingOrders));
            System.out.println();

            // Cancel the newly created order and create a new one @1.000
            System.out.println("+++++ Replacing order: " + newOrderId + " +++++");
            LimitOrderRequest newLimitOrderRequest = new LimitOrderRequest();
            newLimitOrderRequest.setInstrument("EUR_USD");
            newLimitOrderRequest.setUnits(1000.0);
            newLimitOrderRequest.setPrice(1.0000);

            OrderResponse replaceOrderResponse = orderEndpoints.replaceOrder(accountId, newOrderId,
                    newLimitOrderRequest);

            System.out.println("Replace order response:");
            System.out.println(gson.toJson(replaceOrderResponse));
            System.out.println();

            // Cancel the first PENDING order that is not the newly created order
            if (pendingOrders.getOrders() != null) {
                String orderIdToBeCancelled = null; 
                for (Order order : pendingOrders.getOrders()) {
                    if (replaceOrderResponse.getOrderCreateTransaction() != null) {
                        if (!order.getId().equals(replaceOrderResponse.getOrderCreateTransaction().getId())) {
                            orderIdToBeCancelled = order.getId();
                        }
                    }
                    else {
                        orderIdToBeCancelled = order.getId();
                    }
                }
                if (orderIdToBeCancelled != null) {
                    System.out.println("+++++ Cancelling order: " + orderIdToBeCancelled + " +++++");
                    OrderResponse cancelOrderResponse = orderEndpoints.cancelOrder(accountId,
                            orderIdToBeCancelled);
                    System.out.println("Cancel order response:");
                    System.out.println(gson.toJson(cancelOrderResponse));
                    System.out.println();
                }
            }

            // Add clients extensions to the order
            if (replaceOrderResponse.getOrderCreateTransaction() != null) {
                String orderId = replaceOrderResponse.getOrderCreateTransaction().getId();
                System.out.println("+++++ Setting client extensions " + orderId + " +++++");
                ClientExtensionsRequest clientExtensionsRequest = new ClientExtensionsRequest();
                ClientExtensions clientExtensions = new ClientExtensions();
                clientExtensions.setId("TEST_0");
                clientExtensions.setTag("TEST");
                clientExtensions.setComment("Test OANDA v20");
                clientExtensionsRequest.setClientExtensions(clientExtensions);

                ClientExtensionsResponse clientExtensionsResponse =
                        orderEndpoints.setClientExtensions(accountId, orderId, clientExtensionsRequest);
                System.out.println("Client extensions response:");
                System.out.println(gson.toJson(clientExtensionsResponse));
            }
        }
        catch (FxTradeException e) {
            e.printStackTrace();
            System.out.println("Error response code: " + e.getHttpResponseCode() + " message: " +
                    gson.toJson(e.getErrorResponse()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
