package unitconversion.model.measurement;

public abstract class Measurement {
    double value;

    public Measurement(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = Double.parseDouble(value.trim());
    }

    public abstract double convertTo(MeasurementType measurement);
}
