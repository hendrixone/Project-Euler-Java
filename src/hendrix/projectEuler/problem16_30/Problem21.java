package hendrix.projectEuler.problem16_30;

import hendrix.projectEuler.utils.Divisor;

/**
 * Description:
 * Problem21, Amicable numbers
 * <p>
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {
    /*
    Brute force
    */
    private static String solve() {
        //Enumerate all number up to 10000
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            //check if is Amicable
            int divisorSum = Divisor.findAllDivisorSum(i);
            int divisorSum2 = Divisor.findAllDivisorSum(divisorSum);
            if (i == divisorSum2 && i != divisorSum) {
                System.out.println(i + ":" + divisorSum + "," + divisorSum + ":" + Divisor.findAllDivisorSum(divisorSum));
                //add to sum
                sum += i;
            }
        }
        return Integer.toString(sum);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 31626
Process took 363ms to execute
*/