package unitconversion.model.command;

import unitconversion.controller.Controller;

import javax.swing.event.CaretListener;

public class EnableAutoCommand implements Command {
    private final Controller controller;

    public EnableAutoCommand(Controller controller) {
        this.controller = controller;
    }

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
