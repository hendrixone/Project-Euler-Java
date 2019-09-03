package hendrix.projectEuler.problem1_15;

import hendrix.projectEuler.utils.PrimeTools;

/**
 * Description:
 * Problem07, 10001st prime
 * <p>
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10001st prime number?
 */
public class Problem07 {
    /*
    Using the prime tool in utils, by generating a list of primes with the size close to 10001, then return the 10001th
    element which is the answer
    */
    private static String solve() {
        int[] list = PrimeTools.getArray(150000);
        return Integer.toString(list[10000]);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 104743
Process took 77ms to execute
*/