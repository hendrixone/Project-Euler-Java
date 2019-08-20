package hendrix.projectEuler.problem16_30;

import java.math.BigDecimal;

/**
 * Description:
 * Problem20, Factorial digit sum
 * <p>
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * <p>
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class Problem20 {
    /*
    Solved using BigDecimal since normal data type cannot hold such large number, thus a String or an array is used to
    store each digit and do the math on it
    */
    private static String solve() {
        //new BigDecimal to stored the number
        BigDecimal num = new BigDecimal(1);
        //do factorial of 100
        for (int i = 100; i > 0; i--) {
            num = num.multiply(new BigDecimal(i));
        }
        //add up all digits
        String result = num.toString();
        int digitSum = 0;
        for (int i = 0; i < result.length(); i++) {
            digitSum += result.charAt(i) - '0';
        }
        return Integer.toString(digitSum);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 648
Process took 4ms to execute
*/