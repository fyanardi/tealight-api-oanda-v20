package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

public class MethodNotAllowedException extends FxTradeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected MethodNotAllowedException(String errorMessage) {
        super(HttpURLConnection.HTTP_BAD_METHOD, errorMessage);
    }

}
