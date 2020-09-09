// This Java source file was generated on 2020-09-09 10:37:57 (Malay Peninsula Standard Time)
package io.tealight.api.oanda.v20.def.primitive;

public class Instrument {
    private String name;
    private InstrumentType type;
    private String displayName;
    private Integer pipLocation;
    private Integer displayPrecision;
    private Integer tradeUnitsPrecision;
    private Double minimumTradeSize;
    private Double maximumTrailingStopDistance;
    private Double minimumGuaranteedStopLossDistance;
    private Double minimumTrailingStopDistance;
    private Double maximumPositionSize;
    private Double maximumOrderUnits;
    private Double marginRate;
    private InstrumentCommission commission;
    private GuaranteedStopLossOrderModeForInstrument guaranteedStopLossOrderMode;
    private Double guaranteedStopLossOrderExecutionPremium;
    private GuaranteedStopLossOrderLevelRestriction guaranteedStopLossOrderLevelRestriction;
    private InstrumentFinancing financing;
    private Tag[] tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstrumentType getType() {
        return type;
    }

    public void setType(InstrumentType type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getPipLocation() {
        return pipLocation;
    }

    public void setPipLocation(Integer pipLocation) {
        this.pipLocation = pipLocation;
    }

    public Integer getDisplayPrecision() {
        return displayPrecision;
    }

    public void setDisplayPrecision(Integer displayPrecision) {
        this.displayPrecision = displayPrecision;
    }

    public Integer getTradeUnitsPrecision() {
        return tradeUnitsPrecision;
    }

    public void setTradeUnitsPrecision(Integer tradeUnitsPrecision) {
        this.tradeUnitsPrecision = tradeUnitsPrecision;
    }

    public Double getMinimumTradeSize() {
        return minimumTradeSize;
    }

    public void setMinimumTradeSize(Double minimumTradeSize) {
        this.minimumTradeSize = minimumTradeSize;
    }

    public Double getMaximumTrailingStopDistance() {
        return maximumTrailingStopDistance;
    }

    public void setMaximumTrailingStopDistance(Double maximumTrailingStopDistance) {
        this.maximumTrailingStopDistance = maximumTrailingStopDistance;
    }

    public Double getMinimumGuaranteedStopLossDistance() {
        return minimumGuaranteedStopLossDistance;
    }

    public void setMinimumGuaranteedStopLossDistance(Double minimumGuaranteedStopLossDistance) {
        this.minimumGuaranteedStopLossDistance = minimumGuaranteedStopLossDistance;
    }

    public Double getMinimumTrailingStopDistance() {
        return minimumTrailingStopDistance;
    }

    public void setMinimumTrailingStopDistance(Double minimumTrailingStopDistance) {
        this.minimumTrailingStopDistance = minimumTrailingStopDistance;
    }

    public Double getMaximumPositionSize() {
        return maximumPositionSize;
    }

    public void setMaximumPositionSize(Double maximumPositionSize) {
        this.maximumPositionSize = maximumPositionSize;
    }

    public Double getMaximumOrderUnits() {
        return maximumOrderUnits;
    }

    public void setMaximumOrderUnits(Double maximumOrderUnits) {
        this.maximumOrderUnits = maximumOrderUnits;
    }

    public Double getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(Double marginRate) {
        this.marginRate = marginRate;
    }

    public InstrumentCommission getCommission() {
        return commission;
    }

    public void setCommission(InstrumentCommission commission) {
        this.commission = commission;
    }

    public GuaranteedStopLossOrderModeForInstrument getGuaranteedStopLossOrderMode() {
        return guaranteedStopLossOrderMode;
    }

    public void setGuaranteedStopLossOrderMode(GuaranteedStopLossOrderModeForInstrument guaranteedStopLossOrderMode) {
        this.guaranteedStopLossOrderMode = guaranteedStopLossOrderMode;
    }

    public Double getGuaranteedStopLossOrderExecutionPremium() {
        return guaranteedStopLossOrderExecutionPremium;
    }

    public void setGuaranteedStopLossOrderExecutionPremium(Double guaranteedStopLossOrderExecutionPremium) {
        this.guaranteedStopLossOrderExecutionPremium = guaranteedStopLossOrderExecutionPremium;
    }

    public GuaranteedStopLossOrderLevelRestriction getGuaranteedStopLossOrderLevelRestriction() {
        return guaranteedStopLossOrderLevelRestriction;
    }

    public void setGuaranteedStopLossOrderLevelRestriction(GuaranteedStopLossOrderLevelRestriction guaranteedStopLossOrderLevelRestriction) {
        this.guaranteedStopLossOrderLevelRestriction = guaranteedStopLossOrderLevelRestriction;
    }

    public InstrumentFinancing getFinancing() {
        return financing;
    }

    public void setFinancing(InstrumentFinancing financing) {
        this.financing = financing;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

}
