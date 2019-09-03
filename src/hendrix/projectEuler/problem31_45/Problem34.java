package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.MathOps;

/**
 * Description:
 * Problem34, Digit factorials
 * <p>
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * <p>
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * <p>
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34 {
    /*
    easily solved using brute force
    note:
    can be improved by add a break point while calculating the factorial
    */
    private static String solve() {
        int sum = 0;
        for (int i = 3; i < 100000; i++) {
            if (findDigitsFactorial(i) == i) {
                System.out.println(i);
                sum += i;
                System.out.println(sum);
            }
        }
        return Integer.toString(sum);
    }

    /*
    find the sum of digit factorial
     */
    private static int findDigitsFactorial(int num) {
        int sum = 0;
        while (num > 0) {
            sum += MathOps.factorial(num % 10);
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 40730
Process took 28ms to execute
*/