package unitconversion.view;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;

import java.awt.*;

/**
 * The type Meter conversion area.
 */
public class MeterConversionArea extends AbstractJTextArea {

    private final MeasurementType type = MeasurementType.METER;

    /**
     * Instantiates a new Meter conversion area.
     */
    public MeterConversionArea() {
        setBackground(Color.ORANGE);
    }

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
