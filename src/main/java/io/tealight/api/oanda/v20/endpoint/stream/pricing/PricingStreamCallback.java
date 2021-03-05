package io.tealight.api.oanda.v20.endpoint.stream.pricing;

import io.tealight.api.oanda.v20.def.pricing.ClientPrice;

/**
 * Interface for pricing stream callback
 *
 * @author Fredy Yanardi
 *
 */
public interface PricingStreamCallback {

    /**
     * Called when there is a new client price received from the pricing stream
     *
     * @param clientPrice
     */
    public void onClientPrice(ClientPrice clientPrice);

    /**
     * Called when there is an error on receiving the price stream after subscription is established
     */
    public void onError();

    /**
     * Called when the subscription of this callback has been removed
     */
    public void onUnsubscribed();

}
