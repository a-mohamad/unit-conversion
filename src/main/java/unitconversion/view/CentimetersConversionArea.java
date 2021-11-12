package unitconversion.view;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;

import java.awt.*;

public class CentimetersConversionArea extends AbstractJTextArea {

    private final MeasurementType type = MeasurementType.CENTIMETER;

    public CentimetersConversionArea() {
        setBackground(Color.YELLOW);
    }

    @Override
    public void update(ValueToConvert valueToConvert) {
        if (valueToConvert.getType() == type)
            return;

        double value = valueToConvert.getValue();
        double result = switch (valueToConvert.getType()) {
            case CENTIMETER -> value;
            case FEET -> 0.0328084 * value;
            case METER -> 0.01 * value;
        };

        setText("%s %s".formatted(result, type.suffix()));
    }
}
