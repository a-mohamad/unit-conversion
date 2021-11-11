package unitconversion.model;

import unitconversion.model.measurement.*;
import unitconversion.view.TextAreaView;

import java.util.LinkedList;
import java.util.List;

public class ValueToConvert implements Subject {
    private final List<Observer> observers = new LinkedList<>();
    private Measurement measurement;
    private MeasurementType type;

    public void setMeasurement(String value, TextAreaView.ViewType viewType) throws NumberFormatException {
        double val;
        if (value.isEmpty() || value.isBlank())
            val = 0;
        else
            val = Double.parseDouble(value.split(" ")[0]);

        measurement = switch (viewType) {
            case CENTIMETERS -> {
                type = MeasurementType.CENTIMETER;
                yield new Centimeter(val);
            }
            case FEET -> {
                type = MeasurementType.FEET;
                yield new Feet(val);
            }
            case METER -> {
                type = MeasurementType.METER;
                yield new Meter(val);
            }
        };
    }

    public Measurement getMeasurement() {
        return measurement;
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

    public MeasurementType getType() {
        return type;
    }
}
