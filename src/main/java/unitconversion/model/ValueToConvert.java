package unitconversion.model;

import java.util.LinkedList;
import java.util.List;

public class ValueToConvert implements Subject {
    private final List<Observer> observers = new LinkedList<>();
    private MeasurementType type;
    private double value;

    public void setMeasurement(String value, MeasurementType type) throws NumberFormatException {
        double val;
        if (value.isEmpty() || value.isBlank())
            val = 0;
        else
            val = Double.parseDouble(value.split(" ")[0]);

        this.value = val;
        this.type = type;
    }

    public MeasurementType getType() {
        return type;
    }

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
