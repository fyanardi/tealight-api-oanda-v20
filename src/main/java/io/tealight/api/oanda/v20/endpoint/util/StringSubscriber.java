package io.tealight.api.oanda.v20.endpoint.util;

import java.net.http.HttpResponse.BodySubscriber;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.tealight.api.oanda.v20.adapter.OrderAdapter;
import io.tealight.api.oanda.v20.adapter.PrimitiveGsonAdapters;
import io.tealight.api.oanda.v20.adapter.TransactionAdapter;
import io.tealight.api.oanda.v20.def.order.Order;
import io.tealight.api.oanda.v20.def.transaction.Transaction;

/**
 * A stream subscriber class that helps to subscribe and receive response body from a chunked http
 * response received from Oanda stream connection, deserialize every line of the stream and invoke
 * the passed in callback Consumer as an instance of the generic type <T>
 *
 * Adapted from:
 * https://stackoverflow.com/questions/52669764/how-do-you-read-and-print-a-chunked-http-response-using-java-net-http-as-chunks
 *
 * @author Fredy Yanardi
 *
 * @param <T> the class of the stream object
 */
public class StringSubscriber<T> implements BodySubscriber<T> {

    private final CompletableFuture<T> bodyCF = new CompletableFuture<>();
    private final Consumer<T> consumer;
    private final Class<T> clazz;
    private final Gson gson;
    private Flow.Subscription subscription;
    private boolean subscribed = false;

    /**
     * Constructs a StringSubscriber with the type parameter <T> that indicates the expected type
     * of each line from the stream (except the heartbeat)
     * 
     * @param consumer the consumer of the strings with every line of string serialized into
     *        instance of <T>
     * @param clazz class of <T>
     */
    public StringSubscriber(Consumer<T> consumer, Class<T> clazz) {
        this.consumer = consumer;
        this.clazz = clazz;

        this.gson = PrimitiveGsonAdapters.newGsonBuilder()
                .registerTypeAdapter(Order.class, new OrderAdapter())
                .registerTypeAdapter(Transaction.class, new TransactionAdapter())
                .create();
    }

    @Override
    public CompletionStage<T> getBody() {
        return bodyCF;
    }

    @Override
    public synchronized void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1); // Request first item
        this.subscribed = true;
    }

    @Override
    public synchronized void onNext(List<ByteBuffer> buffers) {
        // No longer subscribed (cancelled)
        if (!subscribed) {
            System.out.println("subscribed=false");
            return;
        }

        String buffer = asString(buffers);

        for (String entry : buffer.split("\n")) {
            JsonObject jsonObject = JsonParser.parseString(entry).getAsJsonObject();

            if (!jsonObject.has("type")) {
                subscription.cancel();
                return;
            }

            String type = jsonObject.get("type").getAsString();
            if (type.equals("HEARTBEAT")) {
                // Heartbeat
            }
            else {
                T streamObject = gson.fromJson(jsonObject, clazz);
                consumer.accept(streamObject);
            }
        }

        buffers.forEach(ByteBuffer::rewind); // Rewind after reading
        subscription.request(1); // Request next item
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        bodyCF.completeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
        bodyCF.complete(null);
    }

    /**
     * Cancel current subscription
     */
    public synchronized void cancel() {
        subscription.cancel();
    }

    private String asString(List<ByteBuffer> buffers) {
        return new String(toBytes(buffers), StandardCharsets.UTF_8);
    }

    private byte[] toBytes(List<ByteBuffer> buffers) {
        int size = buffers.stream().mapToInt(ByteBuffer::remaining).sum();
        byte[] bs = new byte[size];
        int offset = 0;
        for (ByteBuffer buffer : buffers) {
            int remaining = buffer.remaining();
            buffer.get(bs, offset, remaining);
            offset += remaining;
        }
        return bs;
    }

}
