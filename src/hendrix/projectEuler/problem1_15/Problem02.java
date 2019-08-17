package hendrix.projectEuler.problem1_15;

import hendrix.projectEuler.utils.Fibonacci;

/**
 * Description:
 * Problem02, Even Fibonacci numbers
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem02 {
    /*
    Using the utils.Fibonacci to generate a sequence upto 4million, add up all the even term
    */
    private static String solve() {
        Fibonacci.initByMax(4000000);
        int[] list = Fibonacci.toArray();
        int sum = 0;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] % 2 == 0) {
                sum += list[i];
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
Answer: 4613732
Process took 4ms to execute
*/