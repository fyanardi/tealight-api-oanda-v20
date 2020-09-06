// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

import io.tealight.api.oanda.v20.def.primitive.GuaranteedStopLossOrderLevelRestriction;

public class GuaranteedStopLossOrderEntryData {
    private Double minimumDistance;
    private Double premium;
    private GuaranteedStopLossOrderLevelRestriction levelRestriction;

    public Double getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(Double minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public GuaranteedStopLossOrderLevelRestriction getLevelRestriction() {
        return levelRestriction;
    }

    public void setLevelRestriction(GuaranteedStopLossOrderLevelRestriction levelRestriction) {
        this.levelRestriction = levelRestriction;
    }

}
