package bsu.edu.cs495.binarycalculator.tests;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import sample.Main;
import sample.util.BinaryConverter;
import sample.util.CalculatorFunctions;

public class Tests {

    @Test
    public void startAppTest() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new Main().start(new Stage()); // Create and initialize the app.
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        thread.start();// Initialize the thread
        Thread.sleep(5000); // Time to use the app, with out this, the thread
        // will be killed before you can tell.
    }

    @Test
    public void binaryToDecimalTest() {
        String bc = BinaryConverter.convertBinaryToDecimal("1010");
        Assert.assertEquals("10", bc);
    }

    @Test
    public void decimalToBinaryTest(){
        String bc = BinaryConverter.convertDecimalToBinary("10");
        Assert.assertEquals("1010", bc);
    }

    @Test
    public void binaryAdditionTest(){
        String ba = CalculatorFunctions.addition("1010", "1010");
        Assert.assertEquals("10100", ba);
    }

    @Test
    public void binarySubtractionTest(){
        String bs = CalculatorFunctions.subtraction("10100", "1010");
        Assert.assertEquals("1010", bs);
    }

    @Test
    public void binaryDivisionTest(){
        String bd = CalculatorFunctions.division("10100", "10100");
            Assert.assertEquals("1", bd);
    }

    @Test
    public void binaryMultiplication(){
        String bm = CalculatorFunctions.multiply("10", "10");
        Assert.assertEquals("100", bm);
    }

    @Test
    public void binarySquareRoot(){
        String bsr = CalculatorFunctions.squareRoot("10000");
        Assert.assertEquals("100", bsr);
    }

    @Test
    public void binarySquare(){
        String bs = CalculatorFunctions.square("100");
        Assert.assertEquals("10000", bs);
    }
}
