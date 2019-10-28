package hendrix.projectEuler.utils;

import java.util.Arrays;
import java.util.LinkedList;

public class Divisor {
    public static LinkedList<Integer> findAllDivisor(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        int half = num / 2;

        for (int i = 1; i <= half; i++) {
            if (num % i == 0)
                list.add(i);
        }
        return list;
    }

    public static int findAllDivisorSum(int num) {
        LinkedList<Integer> divisors = findAllDivisor(num);
        int sum = 0;
        for (Integer i : divisors) {
            sum += i;
        }
        return sum;
    }

    public static LinkedList<Integer> findPrimeFactors(int num){
        LinkedList<Integer> factors = new LinkedList<>();
        int[] primes = PrimeTools.getArray(num + 1);
        while(num != 1) {
            for (int prime : primes) {
                if (num % prime == 0) {
                    num /= prime;
                    factors.add(prime);
                    break;
                }
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l = findPrimeFactors(644);
        System.out.println(Arrays.toString(l.toArray()));
    }
}
