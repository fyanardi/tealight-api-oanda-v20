package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

import io.tealight.api.oanda.v20.def.ErrorResponse;

/**
 * This exception is the base of all exception types that can be thrown during a request to
 * fxTrade server 
 *
 * @author Fredy Yanardi
 *
 */
public class FxTradeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Standard HTTP response code returned by the fxTrade server
     */
    private final int httpResponseCode;

    /**
     * Additional error message string returned by the fxTrade server detailing the error
     */
    // private final String errorMessage;

    /**
     * Additional error response object returned by the fxTrade server detailing the error
     */
    private final ErrorResponse errorResponse;

    /* protected FxTradeException(int httpResponseCode, String errorMessage) {
        super(errorMessage);

        this.httpResponseCode = httpResponseCode;
        this.errorMessage = errorMessage;
    } */

    protected FxTradeException(int httpResponseCode, ErrorResponse errorResponse) {
        super(errorResponse.getErrorMessage());

        this.httpResponseCode = httpResponseCode;
        this.errorResponse = errorResponse;
    }

    /**
     * Get the corresponding HTTP response code returned by fxTrade server that is the cause of
     * this exception
     * 
     * @return HTTP response code
     */
    public int getHttpResponseCode() {
        return httpResponseCode;
    }

    /**
     * Get the additional error message returned by the fxTrade server detailing the error that
     * occurred
     * 
     * @return additional error message returned by the fxTrade server
     */
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    /**
     * Create an instance of FxTradeException based on the HTTP response code. Return one of the
     * subclass of FxTradeException instance if the HTTP response code is one of the documented
     * HTTP response code, or an instance of generic FxTradeException if the HTTP respose code
     * is not recognized
     *
     * @param httpResponseCode HTTP response code returned by fxTrade server
     * @param errorMessage additional error message information returned by the fxTrade server
     * @return an instance of FxTradeException corresponding to the HTTP response code
     */
    /* public static FxTradeException fromHttpResponseCode(int httpResponseCode, String errorMessage) {
        switch (httpResponseCode) {
        case HttpURLConnection.HTTP_BAD_REQUEST:
            return new BadRequestException(errorMessage);
        case HttpURLConnection.HTTP_FORBIDDEN:
            return new ForbiddenException(errorMessage);
        case HttpURLConnection.HTTP_BAD_METHOD:
            return new MethodNotAllowedException(errorMessage);
        case HttpURLConnection.HTTP_NOT_FOUND:
            return new NotFoundException(errorMessage);
        case HttpURLConnection.HTTP_UNAUTHORIZED:
            return new Unauthorized(errorMessage);
        default:
            return new FxTradeException(httpResponseCode, errorMessage);
        }
    } */

    /**
     * Create an instance of FxTradeException based on the HTTP response code. Return one of the
     * subclass of FxTradeException instance if the HTTP response code is one of the documented
     * HTTP response code, or an instance of generic FxTradeException if the HTTP respose code
     * is not recognized
     *
     * @param httpResponseCode HTTP response code returned by fxTrade server
     * @param errorMessage additional error message information returned by the fxTrade server
     * @return an instance of FxTradeException corresponding to the HTTP response code
     */
    public static FxTradeException fromHttpResponseCode(int httpResponseCode, ErrorResponse errorResponse) {
        switch (httpResponseCode) {
        case HttpURLConnection.HTTP_BAD_REQUEST:
            return new BadRequestException(errorResponse);
        case HttpURLConnection.HTTP_FORBIDDEN:
            return new ForbiddenException(errorResponse);
        case HttpURLConnection.HTTP_BAD_METHOD:
            return new MethodNotAllowedException(errorResponse);
        case HttpURLConnection.HTTP_NOT_FOUND:
            return new NotFoundException(errorResponse);
        case HttpURLConnection.HTTP_UNAUTHORIZED:
            return new Unauthorized(errorResponse);
        default:
            return new FxTradeException(httpResponseCode, errorResponse);
        }
    }
}
