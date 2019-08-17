package hendrix.projectEuler.problem1_15;

/**
 * Description:
 * Problem05, Smallest multiple
 * <p>
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem05 {
    /*
    Brute force, but only looking for numbers that are multiples of 1-7, since those number only have prime factor
    */
    private static String solve() {
        boolean breakout = false;
        int result = 0;
        int number = 0;
        while (!breakout) {
            number += 5040;
            for (int i = 1; i <= 20; i++) {
                if (number % i == 0) {
                    if (i == 20) {
                        result = number;
                        breakout = true;
                    }
                } else
                    break;
            }
        }
        return Integer.toString(result);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 232792560
Process took 9ms to execute
*/