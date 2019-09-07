package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.Digits;
import hendrix.projectEuler.utils.Prime;

/**
 * Description:
 * Problem37, Truncatable primes
 * <p>
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
 * <p>
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * <p>
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Problem37 {
    //uses more space for more efficient prime check
    private static Prime prime = new Prime();

    /*
    using tow defined function to check if the number is truncatable
    */
    private static String solve() {
        int sum = 0;
        int count = 0;
        for (int i = 11; i < 10000000 && count < 11; i++) {
            if (truncateRight(i) && truncateLeft(i)) {
                System.out.println(i);
                sum += i;
                count++;
            }

        }
        return Integer.toString(sum);
    }

    private static boolean truncateRight(int num) {
        while (num != 0) {
            if (!prime.isPrime(num))
                return false;
            num /= 10;
        }
        return true;
    }

    private static boolean truncateLeft(int num) {
        Digits n = new Digits(num);
        while (n.length() > 0) {
            if (!prime.isPrime(n.intValue()))
                return false;
            n = n.truncateLEft();
        }
        return true;
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