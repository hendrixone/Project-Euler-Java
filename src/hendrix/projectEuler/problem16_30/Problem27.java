package hendrix.projectEuler.problem16_30;

import hendrix.projectEuler.utils.Prime;

/**
 * Description:
 * Problem27, Quadratic primes
 * <p>
 * Euler discovered the remarkable quadratic formula:
 * <p>
 * n^2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39. However, when n=40,40^2+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,41^2+41+41 is clearly divisible by 41.
 * <p>
 * The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
 * <p>
 * Considering quadratics of the form:
 * <p>
 * n^2+an+b, where |a|<1000 and |b|≤1000
 * <p>
 * where |n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
 */
public class Problem27 {
    /*
    Brute force
    */
    private static String solve() {
        int max = 0;
        int sum = 0;
        //Enumerate all a and b
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int temp = formula(a, b);
                if (temp > max) {
                    max = temp;
                    sum = a * b;
                }
            }
        }
        return Integer.toString(sum);
    }

    /**
     * gives the max n
     *
     * @param a first variable
     * @param b second variable
     * @return number of consecutive prime it can produce
     */
    private static int formula(int a, int b) {
        for (int i = 0; i < 1000; i++) {
            if (!Prime.isPrime((int) Math.pow(i, 2) + (a * i) + b)) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: -59231
Process took 98ms to execute
*/