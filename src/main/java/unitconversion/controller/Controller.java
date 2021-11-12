package unitconversion.controller;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;
import unitconversion.view.MainView;

import java.util.Objects;

public record Controller(MainView view, ValueToConvert valueToConvert) {
    public Controller {
        Objects.requireNonNull(view);
        Objects.requireNonNull(valueToConvert);
    }

    public void updateCentimeterText() {
        String value = view.getCentimeterTextArea().getText();
        try {
            valueToConvert.setMeasurement(value, MeasurementType.CENTIMETER);
        } catch (NumberFormatException e) {
            view.showErrorMessage("Error", "Please enter valid number");
        }
        valueToConvert.notifySubscribers(valueToConvert());
    }

    public void updateFeetText() {
        String value = view.getFeetTextArea().getText();
        try {
            valueToConvert.setMeasurement(value, MeasurementType.FEET);
        } catch (NumberFormatException e) {
            view.showErrorMessage("Error", "Please enter valid number");
        }
        valueToConvert.notifySubscribers(valueToConvert());
    }

    public void updateMeterText() {
        String value = view.getMeterTextArea().getText();
        try {
            valueToConvert.setMeasurement(value, MeasurementType.METER);
        } catch (NumberFormatException e) {
            view.showErrorMessage("Error", "Please enter valid number");
        }
        valueToConvert.notifySubscribers(valueToConvert());
    }
}
