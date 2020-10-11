package io.tealight.api.oanda.v20.endpoint;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.Objects;

import io.tealight.api.oanda.v20.EndpointRequest;
import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.def.order.ClientExtensionsRejectResponse;
import io.tealight.api.oanda.v20.def.order.ClientExtensionsRequest;
import io.tealight.api.oanda.v20.def.order.ClientExtensionsResponse;
import io.tealight.api.oanda.v20.def.order.Order;
import io.tealight.api.oanda.v20.def.order.OrderCancelRejectResponse;
import io.tealight.api.oanda.v20.def.order.OrderCreateRequest;
import io.tealight.api.oanda.v20.def.order.OrderRejectResponse;
import io.tealight.api.oanda.v20.def.order.OrderReplaceRequest;
import io.tealight.api.oanda.v20.def.order.OrderResponse;
import io.tealight.api.oanda.v20.def.order.OrdersResponse;
import io.tealight.api.oanda.v20.endpoint.query.order.OrdersQuery;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;

/**
 * Order endpoints
 * 
 * https://developer.oanda.com/rest-live-v20/order-ep/
 *
 * @author Fredy Yanardi
 */
public class OrderEndpoints {

    private static final String ORDERS = "/v3/accounts/%s/orders";
    private static final String PENDING_ORDERS = "/v3/accounts/%s/pendingOrders";
    private static final String ORDER = "/v3/accounts/%s/orders/%s";
    private static final String REPLACE_ORDER = "/v3/accounts/%s/orders/%s";
    private static final String CANCEL_ORDER = "/v3/accounts/%s/orders/%s/cancel";
    private static final String CLIENT_EXTENSIONS = "/v3/accounts/%s/orders/%s/clientExtensions";

    private final FxTradeContext fxTradeContext;

    public OrderEndpoints(FxTradeContext fxTradeContext) {
        this.fxTradeContext = fxTradeContext;
    }

    /**
     * Create an Order for an Account
     * 
     * @param accountId Account Identifier [required]
     * @param orderCreateRequest OrderCreateRequest instance that specifies the order to be created
     *      [required]
     * @return details of the order created
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public OrderResponse createOrder(String accountId, OrderCreateRequest orderCreateRequest)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(orderCreateRequest);

        String endpoint = String.format(ORDERS, accountId);

        EndpointRequest<OrderResponse> endpointRequest =
                new EndpointRequest.Builder<OrderResponse>(OrderResponse.class)
                    .httpMethod(HttpMethod.POST)
                    .request(orderCreateRequest)
                    .errorResponseFunction((httpResponseCode) -> {
                        return OrderRejectResponse.class;
                    })
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    /**
     * Get a list of Orders for an Account
     *
     * @param accountId Account Identifier [required]
     * @param ordersQuery OrdersQuery instance that specifies the orders to be retrieved
     * @return the list of Orders for an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public OrdersResponse getOrders(String accountId, OrdersQuery ordersQuery)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        Map<String, String> queries = null;
        if (ordersQuery != null) {
            queries = FxTradeEndpointsUtils.queryFromQueryObject(ordersQuery);
        }

        String endpoint = String.format(ORDERS, accountId);

        EndpointRequest<OrdersResponse> endpointRequest =
                new EndpointRequest.Builder<OrdersResponse>(OrdersResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    /**
     * List all pending Orders in an Account
     *
     * @param accountId Account Identifier [required]
     * @return all pending Orders in an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public OrdersResponse getPendingOrders(String accountId) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(PENDING_ORDERS, accountId);
        return fxTradeContext.requestEndpoint(endpoint, OrdersResponse.class);
    }

    /**
     * Get details for a single Order in an Account
     *
     * @param accountId Account Identifier [required]
     * @param orderSpecifier The Order Specifier [required]
     * @return details for a single Order in an Account
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public Order getOrder(String accountId, String orderSpecifier)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(orderSpecifier);

        String endpoint = String.format(ORDER, accountId, orderSpecifier);
        return fxTradeContext.requestEndpoint(endpoint, Order.class);
    }

    /**
     * Replace an Order in an Account by simultaneously canceling it and creating a replacement Order
     * 
     * @param accountId Account Identifier [required]
     * @param orderSpecifier The Order Specifier [required]
     * @param orderReplaceRequest OrderReplaceRequest instance that specifies the order to be
     *      created [required]
     * @return details of the order created
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public OrderResponse replaceOrder(String accountId, String orderSpecifier,
            OrderReplaceRequest orderReplaceRequest) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(orderSpecifier);
        Objects.requireNonNull(orderReplaceRequest);

        String endpoint = String.format(REPLACE_ORDER, accountId, orderSpecifier);

        EndpointRequest<OrderResponse> endpointRequest =
                new EndpointRequest.Builder<OrderResponse>(OrderResponse.class)
                    .httpMethod(HttpMethod.PUT)
                    .request(orderReplaceRequest)
                    .errorResponseFunction((httpResponseCode) -> {
                        if (httpResponseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                            return OrderRejectResponse.class;
                        }
                        else if (httpResponseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                            return OrderCancelRejectResponse.class;
                        }
                        return ErrorResponse.class;
                    })
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    /**
     * Cancel a pending Order in an Account
     *
     * @param accountId Account Identifier [required]
     * @param orderSpecifier The Order Specifier [required]
     * @return details of the order cancelled
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public OrderResponse cancelOrder(String accountId, String orderSpecifier)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(orderSpecifier);

        String endpoint = String.format(CANCEL_ORDER, accountId, orderSpecifier);

        EndpointRequest<OrderResponse> endpointRequest =
                new EndpointRequest.Builder<OrderResponse>(OrderResponse.class)
                    .httpMethod(HttpMethod.PUT)
                    .errorResponseFunction((httpResponseCode) -> {
                        if (httpResponseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                            return OrderCancelRejectResponse.class;
                        }
                        return ErrorResponse.class;
                    })
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    /**
     * Update the Client Extensions for an Order in an Account. Do not set, modify, or delete
     * clientExtensions if your account is associated with MT4.
     *
     * @param accountId Account Identifier [required]
     * @param orderSpecifier The Order Specifier [required]
     * @param clientExtensionsRequest the client extensions request [required]
     * @return The transaction that modified the Client Extensions for the order
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public ClientExtensionsResponse setClientExtensions(String accountId, String orderSpecifier,
            ClientExtensionsRequest clientExtensionsRequest) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(orderSpecifier);
        Objects.requireNonNull(clientExtensionsRequest);

        String endpoint = String.format(CLIENT_EXTENSIONS, accountId, orderSpecifier);

        EndpointRequest<ClientExtensionsResponse> endpointRequest =
                new EndpointRequest.Builder<ClientExtensionsResponse>(ClientExtensionsResponse.class)
                    .httpMethod(HttpMethod.PUT)
                    .request(clientExtensionsRequest)
                    .errorResponseFunction((httpResponseCode) -> {
                        return ClientExtensionsRejectResponse.class;
                    })
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }
}
