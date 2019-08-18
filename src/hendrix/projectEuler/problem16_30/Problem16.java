package hendrix.projectEuler.problem16_30;

import java.math.BigDecimal;

/**
 * Description:
 * Problem16, Power digit sum
 * <p>
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sum of the digits of the number 21000?
 */
public class Problem16 {
    /*
    Solved using bigDecimal.pow()
    */
    private static String solve() {
        String num = new BigDecimal(2).pow(1000).toString();
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
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
Answer: 1366
Process took 1ms to execute
*/