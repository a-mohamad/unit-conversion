package unitconversion.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Value to convert.
 */
public class ValueToConvert implements Subject {
    private final List<Observer> observers = new LinkedList<>();
    private MeasurementType type;
    private double value;

    /**
     * Sets measurement.
     *
     * @param value the value
     * @param type  the type
     * @throws NumberFormatException the number format exception
     */
    public void setMeasurement(String value, MeasurementType type) throws NumberFormatException {
        double val;
        if (value.isEmpty() || value.isBlank())
            val = 0;
        else
            val = Double.parseDouble(value.split(" ")[0]);

        this.value = val;
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public MeasurementType getType() {
        return type;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers(ValueToConvert valueToConvert) {
        observers.forEach(o -> o.update(valueToConvert));
    }
}
