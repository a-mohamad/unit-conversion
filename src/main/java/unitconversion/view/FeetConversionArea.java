package unitconversion.view;

import unitconversion.model.MeasurementType;
import unitconversion.model.ValueToConvert;

import java.awt.*;

public class FeetConversionArea extends AbstractJTextArea {

    private final MeasurementType type = MeasurementType.FEET;

    public FeetConversionArea() {
        setBackground(Color.GREEN);
    }

    @Override
    public void update(ValueToConvert valueToConvert) {
        if (valueToConvert.getType() == type)
            return;

        double value = valueToConvert.getValue();
        double result = switch (valueToConvert.getType()) {
            case CENTIMETER -> 30.48 * value;
            case FEET -> value;
            case METER -> 0.3048 * value;
        };

        setText("%s %s".formatted(result, type.suffix()));
    }
}
