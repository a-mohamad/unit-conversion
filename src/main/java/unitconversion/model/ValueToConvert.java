package unitconversion.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The Value to Convert class takes a dependent and converts it from the dependents type to corresponding
 * types of every other dependent. The precondition is that the provided value of the dependent is valid
 * and as such is a numeric. The post condition is that the other dependents have the correct conversion
 * from the first base dependent type.
 */
public class ValueToConvert implements Subject {
    private final List<Observer> observers = new LinkedList<>();
    private MeasurementType type;
    private double value;

    /**
     * Sets measurement of the provided type to the provided string value converted to its corresponding
     * numeric value.
     *
     * @param value is the value that will be converted to an integer and used as the updated value.
     * @param type  is the type of the measurement to be updated.
     * @throws NumberFormatException the number format exception.
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
     * Gets the specific type of measurement.
     *
     * @return the specific type of measurement.
     */
    public MeasurementType getType() {
        return type;
    }

    /**
     * Gets the numeric value that is currently set.
     *
     * @return the numeric value that is currently used.
     */
    public double getValue() {
        return value;
    }

    /**
     * Adds a subscriber to the Observer pattern as a dependent of which the state should be updated provided a
     * change and of which the state should be tracked by the other dependents.
     *
     * @param observer the observer that is used to add the subscriber.
     */
    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifies the other dependents that a state change has occurred and to then update their states correspondingly.
     *
     * @param valueToConvert the value to convert is the state that is changed and must be
     */
    @Override
    public void notifySubscribers(ValueToConvert valueToConvert) {
        observers.forEach(o -> o.update(valueToConvert));
    }
}
