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
 * The type Main view initializes the frame that is used to update the window. It can be thought of as the main access
 * point to the front end. The precondition for this class is that it holds instances of JFrame, Controller,
 * ValueToConvert, JMenuBar and the type text areas. This is so it can use those instances and update the view
 * correspondingly. The post condition is that given an update, the MainView polls the most recent information
 * from each of those instances to create a live updated view for each frame.
 */
public class MainView {
    /**
     * The width used to set the initial GUI size.
     */
    static final int WIDTH = 750;

    /**
     * The height used to set the initial GUI size.
     */
    static final int HEIGHT = 650;

    /**
     * The Frame that is being painted.
     */
    final JFrame frame;

    /**
     * The Controller that connects the view to the logic of the model.
     */
    final Controller controller;

    /**
     * The Value to convert is the converted instance used to make conversions between types.
     */
    final ValueToConvert valueToConvert;

    /**
     * The Commands that are currently available to be fired in the view.
     */
    final HashMap<String, Command> commands = new HashMap<>();

    /**
     * The Menu bar that is rendered.
     */
    final JMenuBar menuBar;

    /**
     * The Centimeter text area where the numeric value of centimeters is displayed.
     */
    AbstractJTextArea centimeterTextArea;

    /**
     * The Feet text area where the numeric value of feet is displayed.
     */
    AbstractJTextArea feetTextArea;

    /**
     * The Meter text area where the numeric value of meters is displayed.
     */
    AbstractJTextArea meterTextArea;

    /**
     * Instantiates a new Main view with the corresponding new instances of JFrame, ValueToConvert etc. needed as
     * a precondition for our view to function as required. Renders the initial frame as well as the corresponding
     * centimeters, feet, and meters panel along with the preset defaults.
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
        final JMenuItem save = createMenuItem(
                "Save input centimeters", "SAVE", KeyStroke.getKeyStroke("alt F"),
                menubarListener
        );
        final JMenuItem enable = createMenuItem(
                "Enable auto conversion", "ENABLE", KeyStroke.getKeyStroke("alt A"),
                menubarListener
        );
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

    /**
     * With the provided parameters creates a JMenuItem used as a menu item during render.
     *
     * @param text is the text to be added to the menu item.
     * @param actionCommand is the command that is performed when this item is triggered.
     * @param accelerator is the key actions that are pressed.
     * @param listener the event listern that is active to capture inputs.
     * @return menuItem which is the corresponding JMenuItem with the parameters.
     */
    private JMenuItem createMenuItem(String text, String actionCommand, KeyStroke accelerator, ActionListener listener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setActionCommand(actionCommand);
        menuItem.setAccelerator(accelerator);
        menuItem.addActionListener(listener);
        return menuItem;
    }

    /**
     * Sets the style of instantiated JFrame with customized dark theme.
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
     * Shows error message provided an error occurs such as not a number error.
     *
     * @param title   the title of the error message be captured.
     * @param message the message that is to be displayed to the user.
     */
    public void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(this.frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Gets the text frame for centimeters so that the instance can be read or updated.
     *
     * @return the text frame instance for centimeters.
     */
    public AbstractJTextArea getCentimeterTextArea() {
        return centimeterTextArea;
    }

    /**
     * Gets the text frame for feet so that the instance can be read or updated.
     *
     * @return the text frame instance for feet.
     */
    public AbstractJTextArea getFeetTextArea() {
        return feetTextArea;
    }

    /**
     * Gets the text frame for meters so that the instance can be read or updated.
     *
     * @return the text frame instance for meters.
     */
    public AbstractJTextArea getMeterTextArea() {
        return meterTextArea;
    }
}
