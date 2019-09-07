package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.Digits;
import hendrix.projectEuler.utils.Permutation;
import hendrix.projectEuler.utils.Prime;

/**
 * Description:
 * Problem41, Pandigital prime
 * <p>
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem41 {
    /*
    Using already implemented method in PrimeTools and Digits, just enumerate all primes under 1000000000
    */
    private static String solve() {
        int max = 0;
        Prime prime = new Prime();
        //from 9 digits to 2 digits
        for (int i = 9; i > 1; i--) {
            //Using full arrangement to find all the pandigital numbers of certain number of digits
            Integer[] template = new Integer[i];
            for (int j = 1; j <= i; j++) {
                template[j - 1] = j;
            }
            Permutation<Integer> pandigits = new Permutation<>(template);

            //try to find primes from the pandigital numbers
            while (pandigits.hasNext()) {
                int temp = Digits.intValueOf(pandigits.next());
                if (prime.isPrime(temp)) {
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }

        return Integer.toString(max);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 7652413
Process took 350ms to execute
*/