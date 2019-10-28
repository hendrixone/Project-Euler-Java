package hendrix.projectEuler.problem46_60;

import hendrix.projectEuler.utils.Prime;
import hendrix.projectEuler.utils.PrimeTools;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * Problem50, Consecutive prime sum
 *
 * The prime 41, can be written as the sum of six consecutive primes:
 *
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem50 {
    /*
    Smart brute force, by enumerate all possible consecutive prime sum (using nested for loops) and find the longest one
    */
    private static String solve() {
        //define upper bound
        int bound = 1000000;
        //the upper bound of the prime list has been reduce to the proper size
        int[] primesList = PrimeTools.getArray(bound / 100);
        Prime prime = new Prime();
        //this variable represent the longest length ever reached
        int maxCount = 0;
        int answer = 0;
        //first for loop define the starting point of the consecutive primes
        for (int i = 0; i < primesList.length; i++) {
            //the sum of the current sequence
            int sum = 0;
            //the length of the current sequence
            int count = 0;
            //the second for loop will find all possible answer from the starting point i util the sum reaches the upper bound
            for (int j = i; j < primesList.length; j++) {
                sum += primesList[j];
                count++;
                //if the sum is a prime, a possible answer is found, replace the answer with it if the length is longer
                if(prime.isPrime(sum) && count > maxCount) {
                        answer = sum;
                        maxCount = count;
                }else if(sum >= bound) break;
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
Answer: 997651
Process took 94ms to execute
*/