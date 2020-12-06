package firstExercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()); //Input N from keyboard
            System.out.println(findTheNumberOfCorrectParenthesisExpressions(n)); //Output result
        } catch (Exception e) {
            System.out.println("You entered not a number");
            e.printStackTrace();
        }
    }

    private static int findTheNumberOfCorrectParenthesisExpressions(int n) {  //The number of correct parentheses matches Catalan numbers.
        int[] catalanNumbers = new int[n + 1];

        catalanNumbers[0] = 1; //The zero position in the Catalan row is equal to one.
        for (int i = 0; i < n; i++) {
            catalanNumbers[i + 1] = catalanNumbers[i] * 2 * (2 * i + 1) / (i + 2); //Based on the current value of the row, determines the next element.
        }

        return catalanNumbers[n]; //Returns the last element of the row.
    }

}
