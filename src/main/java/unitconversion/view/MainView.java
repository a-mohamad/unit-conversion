package unitconversion.view;

import com.formdev.flatlaf.FlatDarkLaf;
import unitconversion.controller.Controller;
import unitconversion.controller.MenubarListener;
import unitconversion.model.ValueToConvert;
import unitconversion.model.command.Command;
import unitconversion.model.command.EnableAutoCommand;
import unitconversion.model.command.SaveCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * The type Main view.
 */
public class MainView {
    /**
     * The constant WIDTH.
     */
    /* frame properties */
    static final int WIDTH = 750;
    /**
     * The Height.
     */
    static final int HEIGHT = 650;

    /**
     * The Frame.
     */
    final JFrame frame;
    /**
     * The Controller.
     */
    final Controller controller;
    /**
     * The Value to convert.
     */
    final ValueToConvert valueToConvert;

    /**
     * The Commands.
     */
    /* menu commands */
    final HashMap<String, Command> commands = new HashMap<>();

    /**
     * The Menu bar.
     */
    /* accessible components */
    final JMenuBar menuBar;
    /**
     * The Centimeter text area.
     */
    AbstractJTextArea centimeterTextArea;
    /**
     * The Feet text area.
     */
    AbstractJTextArea feetTextArea;
    /**
     * The Meter text area.
     */
    AbstractJTextArea meterTextArea;

    /**
     * Instantiates a new Main view.
     */
    public MainView() {
        enableLookAndFeel();
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.valueToConvert = new ValueToConvert();
        this.controller = new Controller(this, valueToConvert);

        final JPanel root = new JPanel(new FlowLayout());
        root.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        menuBar = new JMenuBar();
        final JMenu updateModel = new JMenu("Update model");
        commands.put("SAVE", new SaveCommand(this.controller));
        commands.put("ENABLE", new EnableAutoCommand(this.controller));

        final MenubarListener menubarListener = new MenubarListener(commands);
        final JMenuItem save = createMenuItem("Save input centimeters", "SAVE", KeyStroke.getKeyStroke("alt F"), menubarListener);
        final JMenuItem enable = createMenuItem("Enable auto conversion", "ENABLE", KeyStroke.getKeyStroke("alt A"), menubarListener);
        updateModel.add(save);
        updateModel.add(enable);
        menuBar.add(updateModel);

        centimeterTextArea = new CentimetersConversionArea();
        feetTextArea = new FeetConversionArea();
        meterTextArea = new MeterConversionArea();

        this.valueToConvert.addSubscriber(centimeterTextArea);
        this.valueToConvert.addSubscriber(feetTextArea);
        this.valueToConvert.addSubscriber(meterTextArea);

        root.add(feetTextArea);
        root.add(meterTextArea);
        root.add(centimeterTextArea);

        this.frame.add(root);
        this.frame.setJMenuBar(menuBar);
        this.frame.setTitle("Converter");
        this.frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setMinimumSize(new Dimension(280, 0));
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setResizable(true);
        this.frame.pack();
        this.frame.toFront();
        this.frame.setVisible(true);
    }

    private JMenuItem createMenuItem(String text, String actionCommand, KeyStroke accelerator, ActionListener listener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setActionCommand(actionCommand);
        menuItem.setAccelerator(accelerator);
        menuItem.addActionListener(listener);
        return menuItem;
    }

    /**
     * Enable look and feel.
     */
    public void enableLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (final Exception ex) {
            System.err.println("Failed to initialize LaF");
            ex.printStackTrace();
        }
    }

    /**
     * Show error message.
     *
     * @param title   the title
     * @param message the message
     */
    public void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(this.frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Gets centimeter text area.
     *
     * @return the centimeter text area
     */
    public AbstractJTextArea getCentimeterTextArea() {
        return centimeterTextArea;
    }

    /**
     * Gets feet text area.
     *
     * @return the feet text area
     */
    public AbstractJTextArea getFeetTextArea() {
        return feetTextArea;
    }

    /**
     * Gets meter text area.
     *
     * @return the meter text area
     */
    public AbstractJTextArea getMeterTextArea() {
        return meterTextArea;
    }

    /**
     * Gets menu bar.
     *
     * @return the menu bar
     */
    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
