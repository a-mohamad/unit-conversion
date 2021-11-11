package unitconversion.view;

import com.formdev.flatlaf.FlatDarkLaf;
import unitconversion.controller.Controller;
import unitconversion.model.ValueToConvert;

import javax.swing.*;

public abstract class AbstractView implements View {

    protected final JFrame frame;
    protected final Controller controller;
    protected final ValueToConvert valueToConvert;

    public AbstractView() {
        AbstractView.enableLookAndFeel();
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.valueToConvert = new ValueToConvert();
        this.controller = new Controller(this, valueToConvert);
    }

    public static void enableLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (final Exception ex) {
            System.err.println("Failed to initialize LaF");
            ex.printStackTrace();
        }
    }

    @Override
    public void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(this.frame, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
