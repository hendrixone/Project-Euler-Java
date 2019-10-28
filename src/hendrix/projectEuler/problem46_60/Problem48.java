package hendrix.projectEuler.problem46_60;

import java.math.BigInteger;

/**
 * Description:
 * Problem48, Self powers
 *
 * The series, 1^1 + 2^2 + 3^3 + ... + 1010 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Problem48 {
    /*
    Using BigInteger here
    */
    private static String solve() {
        BigInteger num = new BigInteger("0");
        for (int i = 1; i <= 1000; i++) {
            num = num.add(new BigInteger(String.valueOf(i)).pow(i));
        }
        String answer = num.toString();
        return answer.substring(answer.length() - 10);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 9110846700
Process took 42ms to execute
*/