package io.tealight.api.oanda.v20;

import io.tealight.api.oanda.v20.endpoint.AccountEndpoints;
import io.tealight.api.oanda.v20.endpoint.InstrumentEndpoints;

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

}
