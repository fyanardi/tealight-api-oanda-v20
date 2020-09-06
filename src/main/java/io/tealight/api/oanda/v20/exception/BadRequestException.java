package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

public class BadRequestException extends FxTradeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected BadRequestException(String errorMessage) {
        super(HttpURLConnection.HTTP_BAD_REQUEST, errorMessage);
    }

}
