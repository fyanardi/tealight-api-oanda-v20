package io.tealight.api.oanda.v20.endpoint;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import io.tealight.api.oanda.v20.EndpointRequest;
import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.def.account.AccountChangesResponse;
import io.tealight.api.oanda.v20.def.account.AccountConfigurationRequest;
import io.tealight.api.oanda.v20.def.account.AccountConfigurationResponse;
import io.tealight.api.oanda.v20.def.account.AccountInstrumentsResponse;
import io.tealight.api.oanda.v20.def.account.AccountResponse;
import io.tealight.api.oanda.v20.def.account.AccountSummaryResponse;
import io.tealight.api.oanda.v20.def.account.AccountsResponse;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;

/**
 * Account endpoints
 * 
 * https://developer.oanda.com/rest-live-v20/account-ep/
 *
 * @author Fredy Yanardi
 */
public class AccountEndpoints {

    private static final String ACCOUNTS = "/v3/accounts";
    private static final String ACCOUNT = "/v3/accounts/%s";
    private static final String ACCOUNT_SUMMARY = "/v3/accounts/%s/summary";
    private static final String ACCOUNT_INSTRUMENTS = "/v3/accounts/%s/instruments";
    private static final String ACCOUNT_CONFIGURATION = "/v3/accounts/%s/configuration";
    private static final String ACCOUNT_CHANGES = "/v3/accounts/%s/changes";

    private final FxTradeContext fxTradeContext;

    public AccountEndpoints(FxTradeContext fxTradeContext) {
        this.fxTradeContext = fxTradeContext;
    }

    public AccountsResponse getAccounts() throws FxTradeException, IOException {
        return fxTradeContext.requestEndpoint(ACCOUNTS, AccountsResponse.class);
    }

    public AccountResponse getAccount(String accountId) throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(ACCOUNT, accountId);
        return fxTradeContext.requestEndpoint(endpoint, AccountResponse.class);
    }

    public AccountSummaryResponse getAccountSummary(String accountId)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(ACCOUNT_SUMMARY, accountId);
        AccountSummaryResponse accountSummaryResponse = fxTradeContext.requestEndpoint(endpoint,
                AccountSummaryResponse.class);
        // Copy lastTransactionId to the AccountSummary instance
        if (accountSummaryResponse.getAccount() != null) {
            accountSummaryResponse.getAccount().setLastTransactionID(
                    accountSummaryResponse.getLastTransactionID());
        }
        return accountSummaryResponse;
    }

    public AccountInstrumentsResponse getAccountInstrument(String accountId, List<String> instruments)
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        Map<String, String> queries = null;
        if (instruments != null) {
            queries = new LinkedHashMap<>();
            queries.put("instruments", instruments.stream().collect(Collectors.joining(",")));
        }

        String endpoint = String.format(ACCOUNT_INSTRUMENTS, accountId);

        EndpointRequest<AccountInstrumentsResponse> endpointRequest =
                new EndpointRequest.Builder<AccountInstrumentsResponse>(AccountInstrumentsResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    public AccountConfigurationResponse setAccountConfiguration(String accountId,
            AccountConfigurationRequest accountConfigurationRequest) 
                    throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);

        String endpoint = String.format(ACCOUNT_CONFIGURATION, accountId);

        EndpointRequest<AccountConfigurationResponse> endpointRequest =
                new EndpointRequest.Builder<AccountConfigurationResponse>(AccountConfigurationResponse.class)
                    .httpMethod(HttpMethod.PATCH)
                    .request(accountConfigurationRequest)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

    public AccountChangesResponse getAccountChanges(String accountId, String sinceTransactionId) 
            throws FxTradeException, IOException {
        Objects.requireNonNull(accountId);
        Objects.requireNonNull(sinceTransactionId);

        Map<String, String> queries = new LinkedHashMap<>();
        queries.put("sinceTransactionID", sinceTransactionId);

        String endpoint = String.format(ACCOUNT_CHANGES, accountId);

        EndpointRequest<AccountChangesResponse> endpointRequest =
                new EndpointRequest.Builder<AccountChangesResponse>(AccountChangesResponse.class)
                    .httpMethod(HttpMethod.GET)
                    .queries(queries)
                    .build();

        return fxTradeContext.requestEndpoint(endpoint, endpointRequest);
    }

}
