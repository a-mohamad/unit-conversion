package unitconversion.controller;

import unitconversion.model.ValueToConvert;
import unitconversion.view.TextAreaView;
import unitconversion.view.View;

import java.util.Objects;

public record Controller(View view, ValueToConvert valueToConvert) {
    public Controller {
        Objects.requireNonNull(view);
        Objects.requireNonNull(valueToConvert);
    }

    public void updateCentimeterText() {
        String value = view.getCentimeterTextArea().getText();
        try {
            valueToConvert.setMeasurement(value, TextAreaView.ViewType.CENTIMETERS);
        } catch (NumberFormatException e) {
            view.showErrorMessage("Error", "Please enter valid number");
        }
        valueToConvert.notifySubscribers(valueToConvert());
    }

    public void updateFeetText() {
        String value = view.getFeetTextArea().getText();
        valueToConvert.setMeasurement(value, TextAreaView.ViewType.FEET);
        valueToConvert.notifySubscribers(valueToConvert());
    }

    public void updateMeterText() {
        String value = view.getMeterTextArea().getText();
        valueToConvert.setMeasurement(value, TextAreaView.ViewType.METER);
        valueToConvert.notifySubscribers(valueToConvert());
    }
}
