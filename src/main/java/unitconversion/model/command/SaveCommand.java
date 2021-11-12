package unitconversion.model.command;

import unitconversion.controller.Controller;

/**
 * The type Save command allows for the meters and feet panel to be updated to the conversion of the current
 * centimeters inside the centimeter panel when the Save. The precondition for this class is that the GUI
 * must be rendered, and the post condition is that it will update the conversions for a valid numeric in
 * centimeters to feet and meters panel.
 */
public record SaveCommand(Controller controller) implements Command {
    /**
     * When executed takes the current valid numeric value inside the centimeters panel and then uses that
     * as the base to convert the corresponding feet and meters panel. Precondition is that there is a valid
     * numeric inside the centimeters panel. Post condition is that when clicked, feet and meters panel will
     * have the corresponding feet and meters converted from the centimeters panel.
     */
    @Override
    public void execute() {
        if (controller.view().getFeetTextArea().isFocusOwner())
            controller.updateFeetText();
        else if (controller.view().getMeterTextArea().isFocusOwner())
            controller.updateMeterText();
        else
            controller.updateCentimeterText();
    }
}
