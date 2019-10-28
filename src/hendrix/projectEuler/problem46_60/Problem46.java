package hendrix.projectEuler.problem46_60;

import hendrix.projectEuler.utils.Prime;
import hendrix.projectEuler.utils.PrimeTools;

import java.util.LinkedList;

/**
 * Description:
 * Problem46, Goldbach's other conjecture
 *
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 *
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 *
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class Problem46 {
    /*
    enumerate all odd composite numbers, and deduct a twice of a square from it to see if whether the result is prime of not
    */
    private static String solve() {
        int answer = 0;
        Prime prime = new Prime();
        for (int i = 3; i < 100000; i+=2) {
            //find odd non prime numbers
            if (!prime.isPrime(i)) {
                int bound = (int) Math.sqrt(i/2) + 1;
                boolean breakout = false;
                for (int j = 1; j <= bound; j++) {
                    int sqr = (int) Math.pow(j, 2) * 2;
                    if (prime.isPrime(i - sqr)) {
                        breakout = true;
                        break;
                    }
                }
                if(!breakout) {
                    answer = i;
                    break;
                }
            }
        }
        return Integer.toString(answer);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 5777
Process took 4ms to execute
*/