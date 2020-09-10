package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

import io.tealight.api.oanda.v20.def.ErrorResponse;

public class Unauthorized extends FxTradeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected Unauthorized(ErrorResponse errorResponse) {
        super(HttpURLConnection.HTTP_UNAUTHORIZED, errorResponse);
    }

}
