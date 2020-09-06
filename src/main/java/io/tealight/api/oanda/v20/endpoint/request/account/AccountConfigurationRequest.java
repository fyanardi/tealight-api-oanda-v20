package io.tealight.api.oanda.v20.endpoint.request.account;

public class AccountConfigurationRequest {

    /**
     * Client-defined alias (name) for the Account
     * type: string
     */
    private String alias;

    /**
     * The string representation of a decimal number.
     * type: Double
     */
    private Double marginRate;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Double getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(Double marginRate) {
        this.marginRate = marginRate;
    }
}
