package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

public class ForbiddenException extends FxTradeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected ForbiddenException(String errorMessage) {
        super(HttpURLConnection.HTTP_FORBIDDEN, errorMessage);
    }

}
