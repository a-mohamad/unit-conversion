package unitconversion.model.command;

import unitconversion.controller.Controller;

public record SaveCommand(Controller controller) implements Command {

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
