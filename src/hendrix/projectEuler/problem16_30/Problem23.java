package hendrix.projectEuler.problem16_30;

import hendrix.projectEuler.utils.Divisor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * Problem23, Non-abundant sums
 * <p>
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * <p>
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Problem23 {
    /*
    Brute force!
    */
    private static String solve() {
        //find all abundant number
        ArrayList<Integer> abundantList = new ArrayList<>();
        for (int i = 0; i < 28123; i++) {
            if (isAbundant(i))
                abundantList.add(i);
        }
        //find all sum by enumeration
        Boolean[] numberList = new Boolean[28124];
        Arrays.fill(numberList, false);
        for (int j = 0; j < abundantList.size(); j++) {
            for (int k = j; k < abundantList.size(); k++) {
                int temp = abundantList.get(j) + abundantList.get(k);
                if (temp > 28123)
                    break;
                numberList[temp] = true;
            }
        }
        //find the summation of remaining numbers
        int sum = 0;
        for (int i = 0; i < numberList.length; i++) {
            if (!numberList[i])
                sum += i;
        }
        return Integer.toString(sum);
    }

    private static boolean isAbundant(int num) {
        int divisorSum = Divisor.findAllDivisorSum(num);
        return divisorSum > num;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 4179871
Process took 586ms to execute
*/