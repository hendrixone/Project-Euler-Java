package hendrix.projectEuler.problem1_15;

import hendrix.projectEuler.utils.TextImporter;

import java.math.BigDecimal;

/**
 * Description:
 * Problem13, Large sum
 * <p>
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers(p13.txt).
 */
public class Problem13 {
    /*
    Using BigDecimal provided by java to solve;
    */
    private static String solve() {
        String[] raw = TextImporter.readWithLine("p13.txt");
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < raw.length; i++) {
            sum = sum.add(new BigDecimal(raw[i]));
        }
        return sum.toString().substring(0, 10);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 5537376230
Process took 11ms to execute
*/