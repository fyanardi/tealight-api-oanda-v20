package io.tealight.api.oanda.v20;

import java.io.IOException;

import io.tealight.api.oanda.v20.exception.FxTradeException;

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
     * Make a request to an OANDA fxTrade endpoint with request specified in the endpoint request
     * parameter.
     *
     * @param <T> type of the response
     * @param endpoint the endpoint path
     * @param endpointRequest EndpointRequest instance that specifies how the request should be
     *      performed
     * @return the response received from the fxTrade endpoint
     * @throws FxTradeException thrown if the request to the fxTrade server is not successful
     * @throws IOException thrown if I/O Exception occurs during the request
     */
    public <T> T requestEndpoint(String endpoint, EndpointRequest<T> endpointRequest)
            throws FxTradeException, IOException;

    /**
     * Make a request to an OANDA fxTrade endpoint with GET HTTP method, no query parameters and no
     * request body.
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
