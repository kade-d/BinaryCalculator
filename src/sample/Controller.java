package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class Controller {
    public TextField calculatorDisplay;

    private boolean isDisplayBinary = true;

    @FXML
    public void initialize() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();

            String regex = isDisplayBinary ? "[0-1]*" : "[0-9]*";

            if (text.matches(regex)) {
                return change;
            }

            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        calculatorDisplay.setTextFormatter(textFormatter);
    }

    public void onePressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("1");
    }

    public void zeroPressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("0");
    }

    public void binaryDecimalPressed(ActionEvent actionEvent) {
        isDisplayBinary = !isDisplayBinary;
    }
}
