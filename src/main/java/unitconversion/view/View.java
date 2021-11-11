package unitconversion.view;


public interface View {
    static View createView(ViewType type) {
        return type.create();
    }

    AbstractJTextArea getCentimeterTextArea();

    AbstractJTextArea getFeetTextArea();

    AbstractJTextArea getMeterTextArea();

    void showErrorMessage(String title, String message);

    enum ViewType {

        MAIN_VIEW {
            @Override
            View create() {
                return new MainView();
            }
        };

        abstract View create();
    }
}
