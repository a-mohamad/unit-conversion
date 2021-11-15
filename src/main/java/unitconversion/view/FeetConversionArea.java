package unitconversion.view;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;

import java.awt.*;

/**
 * The type Feet conversion area which is used to convert a given type of measurement type
 * to the corresponding feet conversion. The precondition of this class is that there is a feet
 * panel and a valid conversion numeric is passed. The post condition is that the feet panel is then updated
 * with the correct converted value for feet.
 */
public class FeetConversionArea extends AbstractJTextArea {

    private final MeasurementType type = MeasurementType.FEET;

    /**
     * Instantiates a new Feets' conversion area with the background colour green as specified in the
     * requirements of this lab.
     */
    public FeetConversionArea() {
        setBackground(Color.GREEN);
        insert("0 ft", 0);
    }

    /**
     * Given a value to convert it converts it to the corresponding feet value using the type and conversions.
     *
     * @param valueToConvert the value to convert passed to feet that is then used to get the specific
     *                       type which is then used for the conversion value to update our feet correspondingly.
     */
    @Override
    public void update(ValueToConvert valueToConvert) {
        if (valueToConvert.getType() == type)
            return;

        double value = valueToConvert.getValue();
        double result = switch (valueToConvert.getType()) {
            case CENTIMETER -> value / 30.48;
            case FEET -> value;
            case METER -> 3.2808399 * value;
        };

        setText("%s %s".formatted(result, type.suffix()));
    }
}
