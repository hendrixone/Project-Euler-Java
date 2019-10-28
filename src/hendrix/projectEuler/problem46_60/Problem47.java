package hendrix.projectEuler.problem46_60;

import hendrix.projectEuler.utils.Divisor;
import hendrix.projectEuler.utils.PrimeTools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Description:
 * Problem47, Distinct primes factors
 *
 * The first two consecutive numbers to have two distinct prime factors are:
 *
 * 14 = 2 × 7
 * 15 = 3 × 5
 *
 * The first three consecutive numbers to have three distinct prime factors are:
 *
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 *
 * Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 */
public class Problem47 {
    /*
    Quite confusing question, a lot of logic statement is needed to optimize performance, not very brute force is used here
    */
    private static String solve() {
        int answer = 0;
        int bound = 1000000;
        //the factors is selected from this prime list
        int[] primes = PrimeTools.getArray(bound / 2);
        //enumerate from composite numbers
        for (int i = 2; i < bound; i++) {
            boolean breakout = false;
            //do 4 consecutive number, if one doesn't match, this loop will break and start over from the break point
            for (int j = 0; j < 4; j++) {
                int temp = i + j;
                //Prime number is excluded because they only have one factor
                if(PrimeTools.isPrime(temp)){
                    breakout = true;
                    i = temp;
                    break;
                }
                //find all prime distinct prime factors
                HashSet<Integer> factors = new HashSet<>();
                //by reducing the number until it self become a prime, it's able to find all prime factors
                while(!PrimeTools.isPrime(temp)){
                    for (int prime : primes) {
                        if(temp % prime == 0){
                            temp /= prime;
                            factors.add(prime);
                            break;
                        }
                    }
                    //break the loop when the number have more than 4 prime factors
                    if(factors.size() > 4){
                        break;
                    }
                }
                //add it self as a factor
                factors.add(temp);
                if(factors.size() == 4){
                    continue;
                }else {
                    breakout = true;
                    i = i + j;
                    break;
                }
            }
            if(!breakout){
                answer = i;
                break;
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
Answer: 134043
Process took 286ms to execute
*/