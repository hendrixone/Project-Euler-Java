package hendrix.projectEuler.problem1_15;

import hendrix.projectEuler.utils.TextImporter;

import java.io.IOException;

/**
 * Description:
 * Problem08, Largest product in a series
 * <p>
 * The four adjacent digits in the 1000-digit number(p08.txt) that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * <p>
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
 */
public class Problem08 {
    /*
    Enumerate all possible product, find the largest among them
    */
    private static String solve() throws IOException {
        String numbers = TextImporter.read("p08.txt");
        long max = 0;
        for (int i = 0; i < numbers.length() - 13; i++) {
            long sum = 1;
            for (int j = 0; j < 13; j++) {
                sum *= numbers.charAt(j + i) - '0';
            }
            if (sum > max) {
                max = sum;
            }
        }
        return Long.toString(max);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 23514624000
Process took 22ms to execute
*/