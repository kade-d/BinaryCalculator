package sample.util;

public class BinaryConverter {

    static int convertBinaryToDecimal(String binaryNumber){
        return Integer.parseInt(binaryNumber, 2);
    }

    static String convertDecimalToBinary(int decimalNumber){
        return Integer.toBinaryString(decimalNumber);
    }

}
