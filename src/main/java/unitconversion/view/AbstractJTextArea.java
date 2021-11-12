package unitconversion.view;

import unitconversion.model.Observer;
import unitconversion.model.Subject;
import unitconversion.model.ValueToConvert;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Abstract j text area.
 */
public abstract class AbstractJTextArea extends JTextArea implements Observer {
    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;
    
    /**
     * Instantiates a new Abstract j text area.
     */
    public AbstractJTextArea() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setForeground(Color.BLACK);
        insert("0", 0);
    }
}
