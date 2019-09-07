package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.Prime;

/**
 * Description:
 * Problem35, Circular primes
 * Problem 35
 * <p>
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * <p>
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * <p>
 * How many circular primes are there below one million?
 */
public class Problem35 {

    //Sacrifices space for faster prime checking
    static final Prime prime = new Prime();

    /*
    Enumeration
    */
    private static String solve() {
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            if (check(i))
                count++;
        }
        return Integer.toString(count);
    }

    /*
    return true if all the rotation of the given number is prime
     */
    private static boolean check(int n) {
        String num = Integer.toString(n);
        for (int i = 0; i < num.length(); i++) {
            if (prime.isPrime(n)) {
                n = nextRotation(n, num.length());
            } else
                return false;

        }
        return true;
    }

    private static int nextRotation(int n, int length) {
        int temp = n % 10;
        n /= 10;
        n += temp * Math.pow(10, length - 1);
        return n;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 55
Process took 395ms to execute
*/