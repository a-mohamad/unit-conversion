package unitconversion.model;

/**
 * The enum Measurement type which helps us organize the different type of measurements we have.
 */
public enum MeasurementType {
    /**
     * Centimeter measurement type used to measure centimeters.
     */
    CENTIMETER("cm"),
    /**
     * Feet measurement type used to measure feet.
     */
    FEET("ft"),
    /**
     * Meter measurement type used to measure meters.
     */
    METER("m");
    /**
     * The Suffix for each measurement type.
     */
    String suffix;

    /**
     * When instantiated this adds the corresponding label for the corresponding measurement type.
     *
     * @param suffix the label for each of the different measurement types.
     */
    MeasurementType(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Suffix string of the measurement type.
     *
     * @return the string of the suffix of the measurement type.
     */
    public String suffix() {
        return suffix;
    }
}
