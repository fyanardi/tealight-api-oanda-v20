package io.tealight.api.oanda.v20;

/**
 * Type of an FxTrade account, either real or practice/demo
 *
 * @author Fredy Yanardi
 *
 */
public enum FxTradeType {

    /**
     * Real (non-demo) fxTrade
     */
    FX_TRADE,

    /**
     * Practice / demo fxTrade
     */
    FX_TRADE_PRACTICE
}
