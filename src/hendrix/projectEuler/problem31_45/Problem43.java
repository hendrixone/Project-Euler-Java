package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.Digits;
import hendrix.projectEuler.utils.Permutation;

/**
 * Description:
 * Problem43, NAME
 * INFO
 */
public class Problem43 {
    /*
    Solution description here
    */
    private static String solve() {
        long sum = 0;
        //prepare first 7 prime
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17};
        //prepare all 9 digits pandigital numbers
        Permutation<Byte> nums = new Permutation<>(new Byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        while (nums.hasNext()) {
            Digits num = new Digits(nums.next());
            boolean breakout = false;
            for (int i = 1; i <= primes.length; i++) {
                Digits temp = num.trim(i, i + 2);
                if (temp.value() % primes[i - 1] != 0) {
                    breakout = true;
                    break;
                }
            }
            if (!breakout) {
                sum += num.value();
                System.out.println(num.value());
            }
        }
        System.out.println(Integer.MAX_VALUE);
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
Put result here
*/