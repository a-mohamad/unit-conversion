package unitconversion.view;

import unitconversion.model.Observer;

public interface TextAreaView extends Observer {
    static TextAreaView createView(TextAreaView.ViewType type) {
        return type.create();
    }

    enum ViewType {

        CENTIMETERS {
            @Override
            TextAreaView create() {
                return new CentimetersConversionArea();
            }
        },
        FEET {
            @Override
            TextAreaView create() {
                return new FeetConversionArea();
            }
        },
        METER {
            @Override
            TextAreaView create() {
                return new MeterConversionArea();
            }
        };

        abstract TextAreaView create();
    }
}
