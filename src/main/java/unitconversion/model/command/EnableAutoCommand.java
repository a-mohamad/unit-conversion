package unitconversion.model.command;

import unitconversion.controller.Controller;

import javax.swing.event.CaretListener;

/**
 * The type Enable auto command allows for the meters and feet panel to be automatically be updated
 * when the centimeters panel is changed. The precondition for this class is that the GUI must be
 * rendered, and the post condition is that it will execute the conversions automatically for a valid
 * numeric in centimeters to feet and meters panel.
 */
public record EnableAutoCommand(Controller controller) implements Command {
    /**
     * Adds listeners to text boxes so when an update occurs, the other remaining text boxes are automatically
     * updated as well. Precondition is that the text boxes either all have listeners or none of them have
     * listeners. The post condition is that if none of them have listeners then it enables them, and vice versa.
     * With the output being the three panels either being automatically updated or they were already being
     * updated and as such are no longer updated.
     */
    @Override
    public void execute() {
        CaretListener[] caretListenersC = controller.view().getCentimeterTextArea().getCaretListeners();
        CaretListener[] caretListenersF = controller.view().getFeetTextArea().getCaretListeners();
        CaretListener[] caretListenersM = controller.view().getMeterTextArea().getCaretListeners();

        if (caretListenersC.length == 0 && caretListenersF.length == 0 && caretListenersM.length == 0) {
            controller.view().getCentimeterTextArea().addCaretListener(e -> {
                if (controller.view().getCentimeterTextArea().isFocusOwner())
                    this.controller.updateCentimeterText();
            });
            controller.view().getFeetTextArea().addCaretListener(e -> {
                if (controller.view().getFeetTextArea().isFocusOwner())
                    this.controller.updateFeetText();
            });
            controller.view().getMeterTextArea().addCaretListener(e -> {
                if (controller.view().getMeterTextArea().isFocusOwner())
                    this.controller.updateMeterText();
            });
        } else {
            for (CaretListener listener : caretListenersC)
                controller.view().getCentimeterTextArea().removeCaretListener(listener);
            for (CaretListener listener : caretListenersF)
                controller.view().getFeetTextArea().removeCaretListener(listener);
            for (CaretListener listener : caretListenersM)
                controller.view().getMeterTextArea().removeCaretListener(listener);
        }
    }
}
