package unitconversion.view;

import unitconversion.model.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Abstract JTextArea provides a generic template for the size of each panel as well colour
 * and starting numeric.
 */
public abstract class AbstractJTextArea extends JTextArea implements Observer {
    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;

    /**
     * Instantiates a new AbstractJTextArea with the default dimensions, colour and starting position.
     */
    public AbstractJTextArea() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setForeground(Color.BLACK);
        insert("0", 0);
    }
}
