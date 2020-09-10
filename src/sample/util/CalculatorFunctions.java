package sample.util;
import java.lang.Math;

public class CalculatorFunctions {

    // addition takes two binary numbers and adds them together
    public static String addition(String binaryOne, String binaryTwo) {
        int integerOne = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryOne));
        int integerTwo = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryTwo));

        int answer = integerOne + integerTwo;

        return BinaryConverter.convertDecimalToBinary(Integer.toString(answer));

    }

    // subtraction takes two binary numbers and subtracts them together
    public static String subtraction(String binaryOne, String binaryTwo) {
        int integerOne = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryOne));
        int integerTwo = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryTwo));

        int answer = integerOne - integerTwo;

        return BinaryConverter.convertDecimalToBinary(Integer.toString(answer));
    }

    // square-root takes ont binary number and returns the floored answer
    public static String squareRoot(String binaryOne) {
        int integerOne = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryOne));

        int answer = (int) Math.sqrt( (double) integerOne);

        return BinaryConverter.convertDecimalToBinary(Integer.toString(answer));
    }

    // multiply takes two binary numbers and multiplies them
    public static String multiply(String binaryOne, String binaryTwo){

        int integerOne = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryOne));
        int integerTwo = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryTwo));

        int answer = integerOne * integerTwo;

        return BinaryConverter.convertDecimalToBinary(Integer.toString(answer));
    }

    // division takes two binary numbers and divides them
    public static String division(String binaryOne, String binaryTwo){

        int integerOne = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryOne));
        int integerTwo = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryTwo));

        int answer = integerOne / integerTwo;

        return BinaryConverter.convertDecimalToBinary(Integer.toString(answer));
    }

    // square takes one binary number and multiplies it by itself
    public static String square(String binaryOne){

        double integerOne = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryOne));
        double power = 2;

        double answer = Math.pow(integerOne, power);

        return BinaryConverter.convertDecimalToBinary(Double.toString(answer));
    }
}
