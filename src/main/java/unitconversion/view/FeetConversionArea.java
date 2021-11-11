package unitconversion.view;

import unitconversion.model.ValueToConvert;
import unitconversion.model.measurement.MeasurementType;

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
        setText("%s %s".formatted(valueToConvert.getMeasurement().convertTo(type), type.suffix()));
    }
}
