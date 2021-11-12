package unitconversion.model;

/**
 * The interface Subject used within the Observer pattern. The precondition for this class is that there is a
 * list of dependents with a state that are needed to manage. The post condition is that this class allows
 * for the updating of states of its dependents.
 */
public interface Subject {
    /**
     * Adds subscriber as a dependent.
     *
     * @param observer the observer that is used to add the subscriber.
     */
    void addSubscriber(Observer observer);

    /**
     * Notify subscribers of state changes.
     *
     * @param valueToConvert the value to convert is the state that is changed and must be
     *                       updated across dependents.
     */
    void notifySubscribers(ValueToConvert valueToConvert);
}
