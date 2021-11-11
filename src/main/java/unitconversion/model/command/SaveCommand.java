package unitconversion.model.command;

import unitconversion.controller.Controller;

public class SaveCommand implements Command {
    private final Controller controller;

    public SaveCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        if (controller.view().getCentimeterTextArea().isFocusOwner())
            this.controller.updateCentimeterText();
        if (controller.view().getFeetTextArea().isFocusOwner())
            this.controller.updateFeetText();
        if (controller.view().getMeterTextArea().isFocusOwner())
            this.controller.updateMeterText();
    }
}
