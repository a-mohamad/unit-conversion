package unitconversion.model;

/**
 * The interface Observer which is used to give the template for our Observer pattern.
 */
public interface Observer {
    /**
     * Updates the dependents of the observer pattern to the provided value to convert.
     *
     * @param valueToConvert the value to convert passed to our converted and allows the dependants in
     *                       the observer pattern to be updated to.
     */
    void update(ValueToConvert valueToConvert);
}
