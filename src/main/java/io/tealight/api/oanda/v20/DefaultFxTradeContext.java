package io.tealight.api.oanda.v20;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.tealight.api.oanda.v20.adapter.OrderAdapter;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.def.order.Order;
import io.tealight.api.oanda.v20.def.primitive.AcceptDatetimeFormat;
import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;

/**
 * Default FxTradeContext. This implementation uses:
 * 1. Java native HttpClient (introduced in Java 11)
 * 2. Google GSON to serialize / deserialize JSON objects
 *
 * @author Fredy Yanardi
 *
 */
public class DefaultFxTradeContext implements FxTradeContext {

    private static final String FXPRACTICE_URL = "https://api-fxpractice.oanda.com";
    private static final String FXTRADE_URL = "  https://api-fxtrade.oanda.com";

    private static final AcceptDatetimeFormat ACCEPT_DATETIME_FORMAT = AcceptDatetimeFormat.RFC3339;
    private final String token;
    private final String fxTradeUrl;
    private Gson gson;

    public DefaultFxTradeContext(FxTradeType fxTradeType, String token) {
        this.token = token;

        this.fxTradeUrl = fxTradeType == FxTradeType.FX_TRADE ? FXTRADE_URL : FXPRACTICE_URL;
        this.gson = PrimitiveGsonAdapters.newGsonBuilder()
                .registerTypeAdapter(Order.class, new OrderAdapter()).create();
    }

    @Override
    public <T> T requestEndpoint(String endpoint, Class<T> responseType, HttpMethod httpMethod, 
            Map<String, String> queries, Object request,
            IntFunction<Class<? extends ErrorResponse>> errorResponseFunction) 
                    throws FxTradeException, IOException {
        URI url;
        try {
            if (queries != null) {
                String queryParameters = queries.entrySet().stream().map(entry -> {
                    StringBuilder param = new StringBuilder();
                    try {
                        param.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                        param.append("=");
                        param.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return param.toString();
                }).collect(Collectors.joining("&"));
                url = new URI(fxTradeUrl + endpoint + "?" + queryParameters);
            }
            else {
                url = new URI(fxTradeUrl + endpoint);
            }

            HttpClient httpClient = HttpClient.newBuilder().build();

            Builder httpRequestBuilder = HttpRequest.newBuilder()
                    .uri(url)
                    .setHeader("Content-Type", "application/json")
                    .setHeader("Authorization", "Bearer " + token)
                    .setHeader("Accept-Datetime-Format", ACCEPT_DATETIME_FORMAT.toString());

            if (request != null) {
                String requestString = gson.toJson(request);
                httpRequestBuilder.method(httpMethod.toString(),
                        BodyPublishers.ofString(requestString));
            }
            else {
                httpRequestBuilder.method(httpMethod.toString(), BodyPublishers.noBody());
            }

            HttpResponse<String> response = httpClient.send(httpRequestBuilder.build(),
                    BodyHandlers.ofString());
            String responseBody = response.body();
            if (statusResponseSuccess(response.statusCode())) {
                // System.out.println(responseBody);
                return gson.fromJson(responseBody, responseType);
            }
            else {
                Class<? extends ErrorResponse> errorResponseClass =
                        errorResponseFunction.apply(response.statusCode());
                ErrorResponse errorResponse = null;
                if (errorResponseClass != null) {
                    errorResponse = gson.fromJson(responseBody, errorResponseClass);
                }
                else {
                    errorResponse = gson.fromJson(responseBody, ErrorResponse.class);
                }

                // If there is no error message, try to extract from 'rejectReason'
                if (errorResponse.getErrorMessage() == null) {
                    JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                    if (jsonObject.has("rejectReason")) {
                        errorResponse.setErrorMessage(jsonObject.get("rejectReason").getAsString());
                    }
                }

                throw FxTradeException.fromHttpResponseCode(response.statusCode(), errorResponse);
            }
        }
        catch (IOException e) {
            throw e;
        }
        // Treat these two exceptions as IOException for time being to simplify the API
        catch (InterruptedException | URISyntaxException e) {
            throw new IOException(e);
        }
    }

    @Override
    public synchronized <T> T requestEndpoint(String endpoint, Class<T> responseType)
            throws FxTradeException, IOException {
        return requestEndpoint(endpoint, responseType, HttpMethod.GET, null, null, null);
    }

    private boolean statusResponseSuccess(int httpResponseCode) {
        return httpResponseCode >= HttpURLConnection.HTTP_OK &&
                httpResponseCode < HttpURLConnection.HTTP_MULT_CHOICE;
    }
}
