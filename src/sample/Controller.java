package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {
    public TextField calculatorDisplay;

    public void onePressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("1");
    }

    public void zeroPressed(ActionEvent actionEvent) {
        calculatorDisplay.appendText("0");
    }
}
