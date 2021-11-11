package unitconversion.view;

import unitconversion.model.Observer;
import unitconversion.model.Subject;
import unitconversion.model.ValueToConvert;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractJTextArea extends JTextArea implements TextAreaView, Subject {
    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;

    private final List<Observer> observers = new LinkedList<>();

    public AbstractJTextArea() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setForeground(Color.BLACK);
        insert("0", 0);
    }

    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers(ValueToConvert valueToConvert) {
        observers.forEach(o -> o.update(valueToConvert));
    }
}
