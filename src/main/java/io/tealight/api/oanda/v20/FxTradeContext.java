package io.tealight.api.oanda.v20;

import java.io.IOException;
import java.util.Map;

import io.tealight.api.oanda.v20.exception.FxTradeException;
import io.tealight.api.oanda.v20.http.HttpMethod;

/**
 * Interface for FxTradeContext. An FxTradeContext implementation is responsible for making the
 * HTTP request to OANDA fxTrade server and deserializing the response into the correct Java
 * object instance.
 *
 * @author Fredy Yanardi
 *
 */
public interface FxTradeContext {

    /**
     * Make a request to an OANDA fxTrade endpoint
     *
     * @param <T> type of the response
     * @param endpoint the endpoint path
     * @param responseType Java type of the response
     * @param httpMethod HTTP method to be used for the request to the fxTrade server
     * @param queries a map of query parameters to be appended to the HTTP request as query string
     * @param request request object that will be sent in the request body 
     * @return the response received from the fxTrade endpoint
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public <T> T requestEndpoint(String endpoint, Class<T> responseType, HttpMethod httpMethod,
            Map<String, String> queries, Object request) throws FxTradeException, IOException;

    /**
     * Overloaded method. Make a request to an OANDA fxTrade endpoint with GET HTTP method, no
     * query parameters and no request body.
     *
     * @param <T> type of the response
     * @param endpoint the endpoint path
     * @param responseType Java type of the response
     * @return the response received from the fxTrade endpoint
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public <T> T requestEndpoint(String endpoint, Class<T> responseType)
            throws FxTradeException, IOException;


}
