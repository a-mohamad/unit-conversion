package unitconversion.view;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;

import java.awt.*;

/**
 * The type Meter conversion area which is used to convert a given type of measurement type
 * to the corresponding meter conversion. The precondition of this class is that there is a meter
 * panel and a valid conversion numeric is passed. The post condition is that the meter panel is then updated
 * with the correct converted value for meters.
 */
public class MeterConversionArea extends AbstractJTextArea {

    private final MeasurementType type = MeasurementType.METER;

    /**
     * Instantiates a new Meters' conversion area with the background colour orange as specified in the
     * requirements of this lab.
     */
    public MeterConversionArea() {
        setBackground(Color.ORANGE);
    }

    /**
     * Given a value to convert it converts it to the corresponding meters value using the type and conversions.
     *
     * @param valueToConvert the value to convert passed to meter that is then used to get the specific
     *                       type which is then used for the conversion value to update our meter correspondingly.
     */
    @Override
    public void update(ValueToConvert valueToConvert) {
        if (valueToConvert.getType() == type)
            return;

        double value = valueToConvert.getValue();
        double result = switch (valueToConvert.getType()) {
            case CENTIMETER -> value / 100;
            case FEET -> 3.2808399 * value;
            case METER -> value;
        };

        setText("%s %s".formatted(result, type.suffix()));
    }
}
