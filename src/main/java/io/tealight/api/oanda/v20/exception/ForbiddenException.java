package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

import io.tealight.api.oanda.v20.def.ErrorResponse;

public class ForbiddenException extends FxTradeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected ForbiddenException(ErrorResponse errorResponse) {
        super(HttpURLConnection.HTTP_FORBIDDEN, errorResponse);
    }

}
