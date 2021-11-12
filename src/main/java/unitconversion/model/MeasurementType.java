package unitconversion.model;

/**
 * The enum Measurement type.
 */
public enum MeasurementType {
    /**
     * Centimeter measurement type.
     */
    CENTIMETER("cm"),
    /**
     * Feet measurement type.
     */
    FEET("ft"),
    /**
     * Meter measurement type.
     */
    METER("m");
    /**
     * The Suffix.
     */
    String suffix;

    MeasurementType(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Suffix string.
     *
     * @return the string
     */
    public String suffix() {
        return suffix;
    }
}
