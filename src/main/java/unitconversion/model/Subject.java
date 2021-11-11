package unitconversion.model;

public interface Subject {
    void addSubscriber(Observer observer);

    void removeSubscriber(Observer observer);

    void notifySubscribers(ValueToConvert valueToConvert);
}
