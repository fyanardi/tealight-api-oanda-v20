package io.tealight.api.oanda.v20.endpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import io.tealight.api.oanda.v20.FxTradeContext;
import io.tealight.api.oanda.v20.def.pricing.ClientPrice;
import io.tealight.api.oanda.v20.endpoint.stream.pricing.PricingStreamCallback;
import io.tealight.api.oanda.v20.endpoint.util.StringSubscriber;
import io.tealight.api.oanda.v20.exception.FxTradeException;

/**
 * Pricing endpoints
 * 
 * https://developer.oanda.com/rest-live-v20/pricing-ep/
 *
 * @author Fredy Yanardi
 *
 */
public class PricingEndpoints {

    public static class SubscriptionInfo {
        Map<String, Set<PricingStreamCallback>> subscriptions = new HashMap<>();
        StringSubscriber<ClientPrice> streamSubscriber;
        CompletableFuture<?> future;
    }

    private static final String STREAM = "/v3/accounts/%s/pricing/stream";

    private final FxTradeContext fxTradeContext;

    private final Map<String, SubscriptionInfo> subscriptionMap = new HashMap<>();

    public PricingEndpoints(FxTradeContext fxTradeContext) {
        this.fxTradeContext = fxTradeContext;
    }

    public synchronized void subscribePriceStream(String accountId,
            Map<String, PricingStreamCallback> subscription) throws FxTradeException, IOException {
        SubscriptionInfo subscriptionInfo = subscriptionMap.get(accountId);
        if (subscriptionInfo == null) {
            subscriptionInfo = new SubscriptionInfo();
            subscriptionMap.put(accountId, subscriptionInfo);
        }

        boolean newInstrument = false;
        for (Map.Entry<String, PricingStreamCallback> entry : subscription.entrySet()) {
            String instrument = entry.getKey();
            PricingStreamCallback callback = entry.getValue();
            if (!subscriptionInfo.subscriptions.containsKey(instrument)) {
                subscriptionInfo.subscriptions.put(instrument, new HashSet<>());
                newInstrument = true;
            }
            subscriptionInfo.subscriptions.get(instrument).add(callback);
        }

        // No new instrument subscription, just update the subscription map (above) and return 
        if (!newInstrument) {
            return;
        }

        // Make sure to cancel current subscription
        unsubscribeStream(subscriptionInfo);
        subscribeStream(accountId, subscriptionInfo);
    }

    public synchronized boolean unsubscribePriceStream(String accountId,
            PricingStreamCallback callback) throws FxTradeException, IOException {
        SubscriptionInfo subscriptionInfo = subscriptionMap.get(accountId);
        if (subscriptionInfo == null) {
            return false;
        }

        boolean found = false;
        Set<String> removedInstruments = new HashSet<>();
        for (Map.Entry<String, Set<PricingStreamCallback>> entry :
                subscriptionInfo.subscriptions.entrySet()) {
            String instrument = entry.getKey();
            Set<PricingStreamCallback> callbacks = entry.getValue();
            if (callbacks.remove(callback)) {
                found = true;
                if (callbacks.isEmpty()) {
                    removedInstruments.add(instrument);
                }
            }
        }

        if (!found) {
            return false;
        }

        // No subscription affected, just return
        if (removedInstruments.isEmpty()) {
            return true;
        }

        removedInstruments.forEach(instrument -> subscriptionInfo.subscriptions.remove(instrument));

        unsubscribeStream(subscriptionInfo);

        if (subscriptionInfo.subscriptions.isEmpty()) {
            subscriptionMap.remove(accountId);
            return true;
        }

        subscribeStream(accountId, subscriptionInfo);
        return true;
    }

    private synchronized void subscribeStream(String accountId, SubscriptionInfo subscriptionInfo)
            throws FxTradeException, IOException {
        Set<String> instrumentSet = subscriptionInfo.subscriptions.keySet();
        String[] instruments = instrumentSet.toArray(new String[instrumentSet.size()]);

        String endpoint = String.format(STREAM, accountId);

        StringSubscriber<ClientPrice> streamSubscriber = new StringSubscriber<>((clientPrice) -> {
            onClientPrice(subscriptionInfo, clientPrice);
        }, ClientPrice.class);

        Map<String, String> queries = new HashMap<>();
        queries.put("instruments", String.join(",", instruments));
        try {
            CompletableFuture<?> future = fxTradeContext.subscribeStream(endpoint, queries,
                    streamSubscriber);
            subscriptionInfo.streamSubscriber = streamSubscriber;
            subscriptionInfo.future = future;
        }
        catch (FxTradeException | IOException e) {
            e.printStackTrace();
            streamSubscriber.cancel();
            subscriptionMap.remove(accountId);
            throw e;
        }
    }

    private synchronized boolean unsubscribeStream(SubscriptionInfo subscriptionInfo) {
        if (subscriptionInfo.streamSubscriber != null) {
            subscriptionInfo.streamSubscriber.cancel();
            subscriptionInfo.streamSubscriber = null;
            subscriptionInfo.future.cancel(true);
            subscriptionInfo.future = null;
            return true;
        }

        return false;
    }

    private void onClientPrice(SubscriptionInfo subscriptionInfo, ClientPrice clientPrice) {
        String instrument = clientPrice.getInstrument();
        Set<PricingStreamCallback> callbacks = subscriptionInfo.subscriptions.get(instrument);
        if (callbacks != null) {
            // TODO: different thread for callback?
            for (PricingStreamCallback callback : callbacks) {
                callback.onClientPrice(clientPrice);
            }
        }
    }
}
