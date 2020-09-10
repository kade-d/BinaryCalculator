package sample.util;

public class BinaryConverter {

    public static String convertBinaryToDecimal(String binaryNumber){
        if (binaryNumber.startsWith("-")){
            int decimalNumber = Integer.parseInt(binaryNumber.substring(1), 2);
            return Integer.toString(-decimalNumber);
        }
        int decimalNumber = Integer.parseInt(binaryNumber, 2);
        return Integer.toString(decimalNumber);
    }

    public static String convertDecimalToBinary(String decimalNumber){
        if (decimalNumber.startsWith("-")){
            int parsedNum = Integer.parseInt(decimalNumber.substring(1));
            return "-"+Integer.toBinaryString(parsedNum);
        }
        int parsedNum = Integer.parseInt(decimalNumber);
        return Integer.toBinaryString(parsedNum);
    }

}
