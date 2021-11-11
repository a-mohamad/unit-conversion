package unitconversion.model.measurement;

public class Meter extends Measurement {

    public Meter(double value) {
        super(value);
    }

    @Override
    public double convertTo(MeasurementType measurement) {
        return switch (measurement) {
            case CENTIMETER -> 100 * value;
            case FEET -> 3.2808399 * value;
            case METER -> value;
        };
    }
}
