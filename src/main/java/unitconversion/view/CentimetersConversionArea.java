package unitconversion.view;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;

import java.awt.*;

/**
 * The type Centimeters conversion area which is used to convert a given type of measurement type
 * to the corresponding centimeter conversion. The precondition of this class is that there is a centimeter
 * panel and a valid conversion numeric is passed. The post condition is that the centimeter panel is then updated
 * with the correct converted value for centimeters.
 */
public class CentimetersConversionArea extends AbstractJTextArea {

    private final MeasurementType type = MeasurementType.CENTIMETER;

    /**
     * Instantiates a new Centimeters' conversion area with the background colour yellow as specified in the
     * requirements of this lab.
     */
    public CentimetersConversionArea() {
        setBackground(Color.YELLOW);
        insert("0 cm", 0);
    }

    /**
     * Given a value to convert it converts it to the corresponding centimeters value using the type and conversions.
     *
     * @param valueToConvert the value to convert passed to centimeters that is then used to get the specific
     *                       type which is then used for the conversion value to update our centimeters correspondingly.
     */
    @Override
    public void update(ValueToConvert valueToConvert) {
        if (valueToConvert.getType() == type)
            return;

        double value = valueToConvert.getValue();
        double result = switch (valueToConvert.getType()) {
            case CENTIMETER -> value;
            case FEET -> 0.0328084 * value;
            case METER -> 100 * value;
        };

        setText("%s %s".formatted(result, type.suffix()));
    }
}
