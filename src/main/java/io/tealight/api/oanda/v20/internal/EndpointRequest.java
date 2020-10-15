package io.tealight.api.oanda.v20.internal;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.IntFunction;

import io.tealight.api.oanda.v20.def.ErrorResponse;
import io.tealight.api.oanda.v20.http.HttpMethod;

/**
 * Endpoint request class that represents a request to be sent to one of the endpoint. Use the
 * Builder class to instantiate this class. 
 * instantiate this class, 
 *
 * @author Fredy Yanardi
 *
 * @param <T> type of the response expected from this request object
 */
public class EndpointRequest<T> {
 
    /*
     * Expected Java type of the response
     */
    private Class<T> responseType;

    /*
     * HTTP method to be used for the request to the fxTrade server
     */
    private HttpMethod httpMethod;

    /*
     * a map of query parameters to be appended to the HTTP request as query string
     */
    private Map<String, String> queries;

    /*
     * request object that will be sent in the request body
     */
    private Object request;

    /*
     * Function that returns the type of the error response depending on the http response code
     * returned by the server
     */
    private IntFunction<Class<? extends ErrorResponse>> errorResponseFunction;

    /*
     * Function that processes every pair of response header returned by the server
     */
    private BiConsumer<String, String> headerFunction;

    private EndpointRequest() {
    }

    /**
     * Get the expected Java type of the response
     *
     * @return the expected Java type of the response
     */
    public Class<T> getResponseType() {
        return responseType;
    }

    /**
     * Get the HTTP method to be used for the request to the fxTrade server
     *
     * @return the HTTP method to be used for the request to the fxTrade server
     */
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    /**
     * Get the map of query parameters to be appended to the HTTP request as query string
     *
     * @return the map of query parameters to be appended to the HTTP request as query string
     */
    public Map<String, String> getQueries() {
        return queries;
    }

    /**
     * Get the request object that will be sent in the request body
     *
     * @return the request object that will be sent in the request body
     */
    public Object getRequest() {
        return request;
    }

    /**
     * Get the function that returns the type of the error response depending on the http response code
     * returned by the server
     *
     * @return error response function
     */
    public IntFunction<Class<? extends ErrorResponse>> getErrorResponseFunction() {
        return errorResponseFunction;
    }

    /**
     * Get the function that processes every pair of response header returned by the server
     *
     * @return the function that processes every pair of response header returned by the server
     */
    public BiConsumer<String, String> getHeaderFunction() {
        return headerFunction;
    }

    /**
     * Builder class to build an EndpointRequest instance.
     *
     * @param <T> type of the response expected from the final EndpointRequest instance
     *
     * @author Fredy Yanardi
     *
     */
    public static class Builder<T> {
        private final Class<T> responseType;
        private HttpMethod httpMethod = HttpMethod.GET;
        private Map<String, String> queries;
        private Object request;
        private IntFunction<Class<? extends ErrorResponse>> errorResponseFunction;
        private BiConsumer<String, String> headerFunction;

        /**
         * Build a new builder with the specified response type, GET HTTP method as default and
         * all other request properties not set
         *
         * @param responseType expected Java type of the response
         */
        public Builder(Class<T> responseType) {
            Objects.requireNonNull(responseType);

            this.responseType = responseType;
        }

        /**
         * Set the HTTP method to be used for the request to the fxTrade server
         *
         * @param httpMethod the HTTP method to be used for this request
         * @return this Builder instance
         */
        public Builder<T> httpMethod(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        /**
         * Set the map of query parameters to be appended to the HTTP request as query string
         *
         * @param queries a map of query parameters to be appended to the HTTP request as query string
         * @return this Builder instance
         */
        public Builder<T> queries(Map<String, String> queries) {
            this.queries = queries;
            return this;
        }

        /**
         * Set the request object that will be sent in the request body
         *
         * @param request the request object that will be sent in the request body
         * @return this Builder instance
         */
        public Builder<T> request(Object request) {
            this.request = request;
            return this;
        }

        /**
         * Set the function that returns the type of the error response depending on the http
         * response code returned by the server
         *
         * @param errorResponseFunction a function that returns the type of the error response
         *      depending on the http response code returned by the server
         * @return this Builder instance
         */
        public Builder<T> errorResponseFunction(
                IntFunction<Class<? extends ErrorResponse>> errorResponseFunction) {
            this.errorResponseFunction = errorResponseFunction;
            return this;
        }

        /**
         * Set the function that processes every pair of response header returned by the server
         *
         * @param headerFunction a function that processes every pair of response header returned by
         *      the server
         * @return this Builder instance
         */
        public Builder<T> headerFunction(BiConsumer<String, String> headerFunction) {
            this.headerFunction = headerFunction;
            return this;
        }

        /**
         * Build an EndpointRequest instance based on the specifications set earlier
         *
         * @return EndpoitRequest instance
         */
        public EndpointRequest<T> build() {
            EndpointRequest<T> endpointRequest = new EndpointRequest<T>();
            endpointRequest.responseType = responseType;
            endpointRequest.httpMethod = httpMethod;
            endpointRequest.queries = queries;
            endpointRequest.request = request;
            endpointRequest.errorResponseFunction = errorResponseFunction;
            endpointRequest.headerFunction = headerFunction;

            return endpointRequest;
        }
    }
}
