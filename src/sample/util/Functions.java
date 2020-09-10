package sample.util;

public class Functions {

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
    public static String squareroot(String binaryOne) {
        int integerOne = Integer.parseInt(BinaryConverter.convertBinaryToDecimal(binaryOne));

        int answer = (int) Math.sqrt( (double) integerOne);

        return BinaryConverter.convertDecimalToBinary(Integer.toString(answer));
    }
}
