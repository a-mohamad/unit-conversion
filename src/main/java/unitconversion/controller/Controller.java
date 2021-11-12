package unitconversion.controller;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;
import unitconversion.view.MainView;

import java.util.Objects;

/**
 * The type Controller.
 *
 * Invariants of the controller class is always two instances of MainView and
 * ValueToConvert which both are not null. This allows us to ensure the view is updated
 * and for the appropriate conversions to occur.
 */
public record Controller(MainView view, ValueToConvert valueToConvert) {
    /**
     * Instantiates a new Controller.
     *
     * @param view is the main display from which we will update.
     * @param valueToConvert is the converted used to convert between values.
     */
    public Controller {
        Objects.requireNonNull(view);
        Objects.requireNonNull(valueToConvert);
    }

    /**
     * Update centimeter text with the provided value in the panel. The precondition
     * is that a value can be entered, and the post condition is the value is updated
     * to the provided value given that the entered value is numeric.
     */
    public void updateCentimeterText() {
        String value = view.getCentimeterTextArea().getText();
        try {
            valueToConvert.setMeasurement(value, MeasurementType.CENTIMETER);
        } catch (NumberFormatException e) {
            view.showErrorMessage("Error", "Please enter valid number");
        }
        valueToConvert.notifySubscribers(valueToConvert());
    }

    /**
     * Update feet text with the provided value in the panel. The precondition
     * is that a value can be entered, and the post condition is the value is updated
     * to the provided value given that the entered value is numeric.
     */
    public void updateFeetText() {
        String value = view.getFeetTextArea().getText();
        try {
            valueToConvert.setMeasurement(value, MeasurementType.FEET);
        } catch (NumberFormatException e) {
            view.showErrorMessage("Error", "Please enter valid number");
        }
        valueToConvert.notifySubscribers(valueToConvert());
    }

    /**
     * Update meter text with the provided value in the panel. The precondition
     * is that a value can be entered, and the post condition is the value is updated
     * to the provided value given that the entered value is numeric.
     */
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
