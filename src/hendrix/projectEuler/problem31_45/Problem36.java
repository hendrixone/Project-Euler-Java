package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.CommonTools;

/**
 * Description:
 * Problem36, Double-base palindromes
 * <p>
 * The decimal number, 585 = 1001001001(2) (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Problem36 {
    /*
    it's confirmed that binary form of even number ended with 0, thus, even number are excluded
    */
    private static String solve() {
        int sum = 0;
        //Enumerate all odd numbers
        for (int i = 1; i < 1000000; i += 2) {
            if (CommonTools.isPalindromes(i) && CommonTools.isPalindromes(Integer.toBinaryString(i))) {
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
Answer: 872187
Process took 32ms to execute
*/