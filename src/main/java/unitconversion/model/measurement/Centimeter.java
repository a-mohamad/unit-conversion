package unitconversion.model.measurement;

public class Centimeter extends Measurement {

    public Centimeter(double value) {
        super(value);
    }

    @Override
    public double convertTo(MeasurementType measurement) {
        return switch (measurement) {
            case CENTIMETER -> value;
            case FEET -> 0.0328084 * value;
            case METER -> 0.01 * value;
        };
    }
}
