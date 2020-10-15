package io.tealight.api.oanda.v20.endpoint;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.def.transaction.TransactionFilter;
import io.tealight.api.oanda.v20.def.transaction.TransactionPagesResponse;
import io.tealight.api.oanda.v20.def.transaction.TransactionResponse;
import io.tealight.api.oanda.v20.def.transaction.TransactionsResponse;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;
import io.tealight.api.oanda.v20.internal.EndpointRequest;

/**
 * Transaction endpoints
 * 
 * https://developer.oanda.com/rest-live-v20/transaction-ep/
 *
 * @author Fredy Yanardi
 */
public class TransactionEndpoints {

    private static final String TRANSACTIONS = "/v3/accounts/%s/transactions";
    private static final String TRANSACTION = "/v3/accounts/%s/transactions/%s";
    private static final String TRANSACTIONS_IDRANGE = "/v3/accounts/%s/transactions/idrange";
    private static final String TRANSACTIONS_SINCEID = "/v3/accounts/%s/transactions/sinceid";

    private final FxTradeContext fxTradeContext;

    public TransactionEndpoints(FxTradeContext fxTradeContext) {
        this.fxTradeContext = fxTradeContext;
    }

    /**
     * Get a list of Transactions pages that satisfy a time-based Transaction query.
     * 
     * The transactions are returned in terms of 'pages', every pages is a link to the get
     * transactions by idrange, for example: 
     * {@code https://api-fxtrade.oanda.com/v3/accounts/<ACCOUNT>/transactions/idrange?from=6409&to=6412"}
     * <p>
     * To get transactions within every page, extract start &amp; end of every page by calling
     * {@link #getIdRangeFromPageUrl(String)} and then call
     * {@link #getTransactionsInRange(String, String, String, EnumSet)} to get the details of
     * all transactions in the page.
     *
     * @param accountId Account Identifier [required]
     * @param from The starting time (inclusive) of the time range for the Transactions being queried.
     *      [default=Account Creation Time]
     * @param to The ending time (inclusive) of the time range for the Transactions being queried.
     *      [default=Request Time]
     * @param pageSize The number of Transactions to include in each page of the results.
     *      [default=100, maximum=1000]
     * @param type The filter that restricts the types of Transactions to retrieve.
     * @return details of transactions that match the criteria
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public TransactionPagesResponse getTransactions(String accountId, ZonedDateTime from,
            ZonedDateTime to, Integer pageSize, EnumSet<TransactionFilter> type)
                    throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(TRANSACTIONS, accountId);
        Map<String, String> queries = new LinkedHashMap<>();
        if (from != null) {
            queries.put("from", FxTradeEndpointsUtils.toUtcZonedDateTime(from).toString());
        }
        if (to != null) {
            queries.put("to", FxTradeEndpointsUtils.toUtcZonedDateTime(to).toString());
        }
        if (pageSize != null) {
            queries.put("pageSize", pageSize.toString());
        }
        if (type != null) {
            queries.put("type", toTransactionFiltersString(type));
        }

        EndpointRequest<TransactionPagesResponse> endpointRequest =
                new EndpointRequest.Builder<TransactionPagesResponse>(TransactionPagesResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(!queries.isEmpty() ? queries : null)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    /**
     * Get the details of a single Account Transaction.
     * 
     * @param accountId Account Identifier [required]
     * @param transactionId A Transaction ID [required]
     * @return details of the transaction specified
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public TransactionResponse getTransaction(String accountId, String transactionId)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(transactionId);

        String endpoint = String.format(TRANSACTION, accountId, transactionId);
        return fxTradeContext.requestEndpoint(endpoint, TransactionResponse.class);
    }

    /**
     * Get a range of Transactions for an Account based on the Transaction IDs.
     * 
     * @param accountId Account Identifier [required]
     * @param from The starting Transaction ID (inclusive) to fetch. [required]
     * @param to The ending Transaction ID (inclusive) to fetch. [required]
     * @param type The filter that restricts the types of Transactions to retrieve.
     * @return details of transactions that match the criteria
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public TransactionsResponse getTransactionsInRange(String accountId, String from, String to,
            EnumSet<TransactionFilter> type) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);

        String endpoint = String.format(TRANSACTIONS_IDRANGE, accountId);
        Map<String, String> queries = new LinkedHashMap<>();
        queries.put("from", from);
        queries.put("to", to);
        if (type != null) {
            queries.put("type", toTransactionFiltersString(type));
        }

        EndpointRequest<TransactionsResponse> endpointRequest =
                new EndpointRequest.Builder<TransactionsResponse>(TransactionsResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    /**
     * Get a range of Transactions for an Account starting at (but not including) a provided
     * Transaction ID.
     * 
     * @param accountId Account Identifier [required]
     * @param transactionId The ID of the last Transaction fetched. This query will return all
     *      Transactions newer than the TransactionID. [required]
     * @param type The filter that restricts the types of Transactions to retrieve.
     * @return details of transactions that match the criteria
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public TransactionsResponse getTransactionsSinceId(String accountId, String transactionId,
            EnumSet<TransactionFilter> type) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(transactionId);

        String endpoint = String.format(TRANSACTIONS_SINCEID, accountId);
        Map<String, String> queries = new LinkedHashMap<>();
        queries.put("id", transactionId);
        if (type != null) {
            queries.put("type", toTransactionFiltersString(type));
        }

        EndpointRequest<TransactionsResponse> endpointRequest =
                new EndpointRequest.Builder<TransactionsResponse>(TransactionsResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    /**
     * Extract the 'from' and 'to' from a transaction page returned by
     * {@link #getTransactions(String, ZonedDateTime, ZonedDateTime, Integer, EnumSet)} API
     *
     * @param page the page URL whose 'from' and 'to' are to be extracted
     * @return 'from' and 'to' as {@code Map.Entry<String, String>} instance or null if there is an error
     *      in extracting the information from the page
     * @throws MalformedURLException if the url passed in is invalid / malformed
     */
    public static Map.Entry<String, String> getIdRangeFromPageUrl(String page)
            throws MalformedURLException {
        try {
            URL url = new URL(page);
            String from = null;
            String to = null;
            final String[] pairs = url.getQuery().split("&");
            for (String pair : pairs) {
                String[] nameValue = URLDecoder.decode(pair, "UTF-8").split("=");
                if (nameValue.length != 2) {
                    continue;
                }
                if (nameValue[0].equals("from")) {
                    from = nameValue[1];
                }
                else if (nameValue[0].equals("to")) {
                    to = nameValue[1];
                }
            }
            return from != null && to != null ? new AbstractMap.SimpleEntry<>(from, to) : null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String toTransactionFiltersString(EnumSet<TransactionFilter> type) {
        return type.stream().map(tf -> tf.toString()).collect(Collectors.joining(","));
    }
}
