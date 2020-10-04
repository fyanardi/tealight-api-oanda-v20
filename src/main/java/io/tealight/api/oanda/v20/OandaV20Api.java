package io.tealight.api.oanda.v20;

import io.tealight.api.oanda.v20.endpoint.AccountEndpoints;
import io.tealight.api.oanda.v20.endpoint.InstrumentEndpoints;
import io.tealight.api.oanda.v20.endpoint.OrderEndpoints;
import io.tealight.api.oanda.v20.endpoint.PositionEndpoints;
import io.tealight.api.oanda.v20.endpoint.TransactionEndpoints;

/**
 * Java wrapper for OANDA fxTrade v20 APIs
 *
 * @author Fredy Yanardi
 *
 */
public class OandaV20Api {

    private final FxTradeContext fxTradeContext;

    private AccountEndpoints accountEndpoints;
    private InstrumentEndpoints instrumentEndpoints;
    private OrderEndpoints orderEndpoints;
    private TransactionEndpoints transactionEndpoints;
    private PositionEndpoints positionEndpoints;

    public OandaV20Api(FxTradeType fxTradeType, String token) {
        this.fxTradeContext = new DefaultFxTradeContext(fxTradeType, token);
    }

    /**
     * Get the account endpoints
     *
     * @return the account endpoints
     */
    public AccountEndpoints getAccountEndpoints() {
        if (accountEndpoints == null) {
            accountEndpoints = new AccountEndpoints(fxTradeContext);
        }
        return accountEndpoints;
    }

    /**
     * Get the instrument endpoints
     *
     * @return the instrument endpoints
     */
    public InstrumentEndpoints getInstrumentEndpoints() {
        if (instrumentEndpoints == null) {
            instrumentEndpoints = new InstrumentEndpoints(fxTradeContext);
        }
        return instrumentEndpoints;
    }

    /**
     * Get the order endpoints
     *
     * @return the order endpoints
     */
    public OrderEndpoints getOrderEndpoints() {
        if (orderEndpoints == null) {
            orderEndpoints = new OrderEndpoints(fxTradeContext);
        }
        return orderEndpoints;
    }

    /**
     * Get the transaction endpoints
     *
     * @return the transaction endpoints
     */
    public TransactionEndpoints getTransactionEndpoints() {
        if (transactionEndpoints == null) {
            transactionEndpoints = new TransactionEndpoints(fxTradeContext);
        }
        return transactionEndpoints;
    }

    /**
     * Get the position endpoints
     *
     * @return the position endpoints
     */
    public PositionEndpoints getPositionEndpoints() {
        if (positionEndpoints == null) {
            positionEndpoints = new PositionEndpoints(fxTradeContext);
        }
        return positionEndpoints;
    }
}
