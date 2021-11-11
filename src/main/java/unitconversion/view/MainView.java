package unitconversion.view;

import unitconversion.controller.MenubarListener;
import unitconversion.model.command.Command;
import unitconversion.model.command.EnableAutoCommand;
import unitconversion.model.command.SaveCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MainView extends AbstractView {
    /* frame properties */
    private static final int WIDTH = 750;
    private static final int HEIGHT = 650;
    /* menu commands */
    final HashMap<String, Command> commands = new HashMap<>();
    /* accessible components */
    AbstractJTextArea centimeterTextArea;
    AbstractJTextArea feetTextArea;
    AbstractJTextArea meterTextArea;

    public MainView() {
        final JPanel root = new JPanel(new FlowLayout());
        root.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        final JMenuBar menuBar = new JMenuBar();
        final JMenu updateModel = new JMenu("Update model");
        commands.put("SAVE", new SaveCommand(this.controller));
        commands.put("ENABLE", new EnableAutoCommand(this.controller));

        final MenubarListener menubarListener = new MenubarListener(commands);
        final JMenuItem save = createMenuItem("Save input centimeters", "SAVE", KeyStroke.getKeyStroke("alt F"), menubarListener);
        final JMenuItem enable = createMenuItem("Enable auto conversion", "ENABLE", KeyStroke.getKeyStroke("alt A"), menubarListener);
        updateModel.add(save);
        updateModel.add(enable);
        menuBar.add(updateModel);

        centimeterTextArea = (AbstractJTextArea) TextAreaView.createView(TextAreaView.ViewType.CENTIMETERS);
        feetTextArea = (AbstractJTextArea) TextAreaView.createView(TextAreaView.ViewType.FEET);
        meterTextArea = (AbstractJTextArea) TextAreaView.createView(TextAreaView.ViewType.METER);

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

    @Override
    public AbstractJTextArea getCentimeterTextArea() {
        return centimeterTextArea;
    }

    @Override
    public AbstractJTextArea getFeetTextArea() {
        return feetTextArea;
    }

    @Override
    public AbstractJTextArea getMeterTextArea() {
        return meterTextArea;
    }
}
