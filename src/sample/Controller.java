package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class Controller {
    public TextField calculatorDisplay;

    @FXML
    public void initialize() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();

            if (text.matches("[0-1]*")) {
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
}
