package io.tealight.api.oanda.v20.internal;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;

import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.endpoint.FxTradeEndpointsUtils;
import io.tealight.api.oanda.v20.exception.FxTradeException;

/**
 * A BiConsumer function that processes every response header received from the FxTrade server, and
 * if it finds a 'Link' header, follows it by creating another request.
 * 
 * @author Fredy Yanardi
 *
 * @param <T> the type of the response to be received from the FxTrade server
 */
public class ResponseLinkFollowerFunction<T> implements BiConsumer<String, String> {

    private final FxTradeContext fxTradeContext;
    private final List<T> responses;
    private final Class<T> responseType;

    /**
     * Constructor
     *
     * @param fxTradeContext the FxTradeContext
     * @param responses an immutable List to store the response received from the server
     * @param responseType the expected response type of the response received from the server
     */
    public ResponseLinkFollowerFunction(FxTradeContext fxTradeContext, List<T> responses,
            Class<T> responseType) {
        this.fxTradeContext = fxTradeContext;
        this.responses = responses;
        this.responseType = responseType;
    }

    @Override
    public void accept(String t, String u) {
        if (t.equalsIgnoreCase(FxTradeEndpointsUtils.LINK_RESPONSE_HEADER)) {
            Matcher matcher = FxTradeEndpointsUtils.LINK_HEADER_VALUE_REGEX.matcher(u);
            if (matcher.find()) {
                String link = matcher.group(1);
                // TODO use rel information ('next' or 'prev')
                // String rel = matcher.group(2);

                URI endpointURI = null;
                try {
                    endpointURI = new URI(link);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

                try {
                    T response = fxTradeContext.requestEndpoint(endpointURI, responseType, this);
                    responses.add(response);
                } catch (FxTradeException | IOException e) {
                    // Ignore exception for time being
                    e.printStackTrace();
                }
            }
        }
    }

}
