package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

import static sample.util.BinaryConverter.*;

public class Controller {
    public TextField calculatorDisplay;

    private boolean isDisplayBinary = true;

    @FXML
    public void initialize() {
        UnaryOperator<TextFormatter.Change> filter = change -> {

            if(calculatorDisplay.getText().isEmpty()){
                change.setText("0");
                return change;
            }

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

    public Button binaryDecimalButton;

    public void binaryDecimalPressed(ActionEvent actionEvent) {
        String displayText = calculatorDisplay.getText();
        String convertedText;
        if (isDisplayBinary){
            convertedText = convertBinaryToDecimal(displayText);
            binaryDecimalButton.setText("Decimal");
        }
        else {
            convertedText = convertDecimalToBinary(displayText);
            binaryDecimalButton.setText("Binary");
        }
        isDisplayBinary = !isDisplayBinary;
        calculatorDisplay.setText(convertedText);
    }

    public void clearPressed(ActionEvent actionEvent) {
        calculatorDisplay.setText("0");
    }

    public void deletePressed(ActionEvent actionEvent) {
        if (calculatorDisplay.getLength() > 0) {
            String textMinusLast = calculatorDisplay.getText(0, calculatorDisplay.getLength() - 1);
            calculatorDisplay.setText(textMinusLast);
        }
        if(calculatorDisplay.getText().isEmpty()){
            calculatorDisplay.setText("0");
        }
    }

    public void squareRootPressed(ActionEvent actionEvent) {
    }

    public void squaredPressed(ActionEvent actionEvent) {
    }

    public void onePressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("1");
    }

    public void zeroPressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("0");
    }

    public void dividePressed(ActionEvent actionEvent) {
    }

    public void timesPressed(ActionEvent actionEvent) {
    }

    public void minusPressed(ActionEvent actionEvent) {
    }

    public void plusPressed(ActionEvent actionEvent) {
    }

    public void equalsPressed(ActionEvent actionEvent) {
    }
}
