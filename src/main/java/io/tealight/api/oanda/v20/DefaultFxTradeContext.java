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
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
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
        this.gson = PrimitiveGsonAdapters.newGsonBuilder().create();
    }

    @Override
    public <T> T requestEndpoint(String endpoint, Class<T> responseType, HttpMethod httpMethod, 
            Map<String, String> queries, Object request) throws FxTradeException, IOException {
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
            if (response.statusCode() == HttpURLConnection.HTTP_OK) {
                System.out.println(response.body());
                return gson.fromJson(response.body(), responseType);
            }
            else {
                String errorMessage = null;
                JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
                if (jsonObject.has("errorMessage")) {
                    errorMessage = jsonObject.get("errorMessage").getAsString();
                }
                else if (jsonObject.has("rejectReason")) {
                    errorMessage = jsonObject.get("rejectReason").getAsString();
                }
                throw FxTradeException.fromHttpResponseCode(response.statusCode(), errorMessage);
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
        return requestEndpoint(endpoint, responseType, HttpMethod.GET, null, null);
    }
}
