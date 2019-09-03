package hendrix.projectEuler.problem1_15;

import hendrix.projectEuler.utils.PrimeTools;

/**
 * Description:
 * Prblem10, Summation of primes
 * <p>
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
public class Problem10 {
    /*
    Using utils.prime to generate all primes under 2 million, then find the sum.
    */
    private static String solve() {
        boolean[] primes = PrimeTools.getBoolArray(2000000);
        long sum = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                sum += i;
            }
        }
        return Long.toString(sum);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 142913828922
Process took 2716ms to execute
*/