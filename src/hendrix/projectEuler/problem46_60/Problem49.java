package hendrix.projectEuler.problem46_60;

import hendrix.projectEuler.utils.Digits;
import hendrix.projectEuler.utils.Prime;

import java.util.LinkedList;

/**
 * Description:
 * Problem49, Prime permutations
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Problem49 {
    /*
    Solution description here
    */
    private static String solve() {
        LinkedList answers = new LinkedList();
        Prime prime = new Prime();
        //for all 4 digits number
        for (int i = 1000; i < 10000; i++) {
            //for all prime number
            if(prime.isPrime(i)){
                //increased by j
                for (int j = 1; j < 4500; j++) {
                    //for each term
                    int num2;
                    int num3;
                    //all are prime
                    if(prime.isPrime(num2 = i+j) && prime.isPrime(num3 = i + j + j)){
                        Digits num1 = new Digits(i);
                        //is permutation of each other
                        if(num1.isPermutationOf(new Digits(num2)) && num1.isPermutationOf(new Digits(num3)) && num3 < 10000)
                            answers.add( i+""+(i+j)+""+(i+j+j));
                        else
                            continue;
                    }
                }
            }
        }
        return (String) answers.getLast();
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 296962999629
Process took 224ms to execute
*/