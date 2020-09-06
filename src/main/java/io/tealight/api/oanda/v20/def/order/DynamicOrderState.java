// This Java source file was generated on 2020-09-06 13:40:51 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.order;

public class DynamicOrderState {
    private String id;
    private Double trailingStopValue;
    private Double triggerDistance;
    private Boolean isTriggerDistanceExact;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTrailingStopValue() {
        return trailingStopValue;
    }

    public void setTrailingStopValue(Double trailingStopValue) {
        this.trailingStopValue = trailingStopValue;
    }

    public Double getTriggerDistance() {
        return triggerDistance;
    }

    public void setTriggerDistance(Double triggerDistance) {
        this.triggerDistance = triggerDistance;
    }

    public Boolean getIsTriggerDistanceExact() {
        return isTriggerDistanceExact;
    }

    public void setIsTriggerDistanceExact(Boolean isTriggerDistanceExact) {
        this.isTriggerDistanceExact = isTriggerDistanceExact;
    }

}
