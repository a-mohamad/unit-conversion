package unitconversion.model.measurement;

public class Feet extends Measurement {

    public Feet(double value) {
        super(value);
    }

    @Override
    public double convertTo(MeasurementType measurement) {
        return switch (measurement) {
            case CENTIMETER -> 30.48 * value;
            case FEET -> value;
            case METER -> 0.3048 * value;
        };
    }
}
