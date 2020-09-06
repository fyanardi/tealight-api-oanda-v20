package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

public class Unauthorized extends FxTradeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected Unauthorized(String errorMessage) {
        super(HttpURLConnection.HTTP_UNAUTHORIZED, errorMessage);
    }

}
