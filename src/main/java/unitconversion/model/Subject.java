package unitconversion.model;

/**
 * The interface Subject.
 */
public interface Subject {
    /**
     * Add subscriber.
     *
     * @param observer the observer
     */
    void addSubscriber(Observer observer);

    /**
     * Remove subscriber.
     *
     * @param observer the observer
     */
    void removeSubscriber(Observer observer);

    /**
     * Notify subscribers.
     *
     * @param valueToConvert the value to convert
     */
    void notifySubscribers(ValueToConvert valueToConvert);
}
