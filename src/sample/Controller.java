package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

import static sample.util.BinaryConverter.*;
import static sample.util.CalculatorFunctions.*;

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

            String regex = isDisplayBinary ? "-?[0-1]*" : "-?[0-9]*";

            if (text.matches(regex)) {
                return change;
            }

            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        calculatorDisplay.setTextFormatter(textFormatter);
    }

    public Button binaryDecimalButton;

    public void convertBinaryDecimal(){
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

    public void binaryDecimalPressed(ActionEvent actionEvent) {
        convertBinaryDecimal();
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

    private void displayBinary(){
        if(!isDisplayBinary){
            convertBinaryDecimal();
        }
    }

    public void squareRootPressed(ActionEvent actionEvent) {
        displayBinary();
        String displayText = calculatorDisplay.getText();
        String rootedNumber = squareRoot(displayText);
        calculatorDisplay.setText(rootedNumber);
    }

    public void squaredPressed(ActionEvent actionEvent) {
        displayBinary();
        String displayText = calculatorDisplay.getText();
        String squaredNumber = square(displayText);
        calculatorDisplay.setText(squaredNumber);
    }

    public void onePressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("1");
    }

    public void zeroPressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("0");
    }

    String storedNumber;

    private enum Operation {
        DIVIDE, TIMES, MINUS, PLUS, UNSELECTED
    }

    private Operation currentOperation = Operation.UNSELECTED;

    private void operationPressed(Operation chosenOperation){
        displayBinary();
        storedNumber = calculatorDisplay.getText();
        currentOperation = chosenOperation;
        calculatorDisplay.setText("0");
    }

    public void dividePressed(ActionEvent actionEvent) {
        operationPressed(Operation.DIVIDE);
    }

    public void timesPressed(ActionEvent actionEvent) {
        operationPressed(Operation.TIMES);
    }

    public void minusPressed(ActionEvent actionEvent) {
        operationPressed(Operation.MINUS);
    }

    public void plusPressed(ActionEvent actionEvent) {
        operationPressed(Operation.PLUS);
    }

    public void equalsPressed(ActionEvent actionEvent) {
        displayBinary();
        String result = "0";
        String displayText = calculatorDisplay.getText();
        switch (currentOperation){
            case DIVIDE:
                break;
            case TIMES:
                break;
            case MINUS:
                result = subtraction(storedNumber, displayText);
                break;
            case PLUS :
                result = addition(storedNumber, displayText);
                break;
            case UNSELECTED:
                break;
            default:
        }
        calculatorDisplay.setText(result);
    }
}
