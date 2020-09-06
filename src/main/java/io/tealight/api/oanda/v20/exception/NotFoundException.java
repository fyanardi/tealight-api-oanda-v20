package io.tealight.api.oanda.v20.exception;

import java.net.HttpURLConnection;

public class NotFoundException extends FxTradeException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected NotFoundException(String errorMessage) {
        super(HttpURLConnection.HTTP_NOT_FOUND, errorMessage);
    }

}
