package unitconversion.model;

public enum MeasurementType {
    CENTIMETER("cm"), FEET("ft"), METER("m");
    String suffix;

    MeasurementType(String suffix) {
        this.suffix = suffix;
    }

    public String suffix() {
        return suffix;
    }
}
