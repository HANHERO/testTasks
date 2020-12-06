package thirdExercise;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int sumOfFactorialDigits = 0;
        char [] charArrayOfFactorial = countFactorial(100).toString().toCharArray();//An array of digits for 100!

        for (char c : charArrayOfFactorial) { //Finding the sum of digits factorial 100
            sumOfFactorialDigits += Integer.parseInt(String.valueOf(c));
        }
        System.out.println(sumOfFactorialDigits); //Outputting the sum of digits factorial 100
    }

    private static BigInteger countFactorial(int n) { //Сalculating factorial 100
        BigInteger result = BigInteger.valueOf(1); //BigInteger because factorial 100 is really big number
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result; //648
    }
}