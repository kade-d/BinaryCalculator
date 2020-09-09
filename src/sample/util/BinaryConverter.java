package sample.util;

public class BinaryConverter {

    public static String convertBinaryToDecimal(String binaryNumber){
        int decimalNumber = Integer.parseInt(binaryNumber, 2);
        return Integer.toString(decimalNumber);
    }

    public static String convertDecimalToBinary(String decimalNumber){
        int parsedNum = Integer.parseInt(decimalNumber);
        return Integer.toBinaryString(parsedNum);
    }

}
