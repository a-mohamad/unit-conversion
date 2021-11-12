package unitconversion.view;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;

import java.awt.*;

public class MeterConversionArea extends AbstractJTextArea {

    private final MeasurementType type = MeasurementType.METER;

    public MeterConversionArea() {
        setBackground(Color.ORANGE);
    }

    @Override
    public void update(ValueToConvert valueToConvert) {
        if (valueToConvert.getType() == type)
            return;

        double value = valueToConvert.getValue();
        double result = switch (valueToConvert.getType()) {
            case CENTIMETER -> 100 * value;
            case FEET -> 3.2808399 * value;
            case METER -> value;
        };

        setText("%s %s".formatted(result, type.suffix()));
    }
}
