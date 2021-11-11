package unitconversion.view;

import unitconversion.model.ValueToConvert;
import unitconversion.model.measurement.MeasurementType;

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
        setText("%s %s".formatted(valueToConvert.getMeasurement().convertTo(type), type.suffix()));
    }
}
