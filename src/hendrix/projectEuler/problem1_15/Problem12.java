package hendrix.projectEuler.problem1_15;

/**
 * Description:
 * Problem12, Highly divisible triangular number
 * <p>
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * <p>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <p>
 * Let us list the factors of the first seven triangle numbers:
 * <p>
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 * <p>
 * What is the value of the first triangle number to have over five hundred divisors?
 */
public class Problem12 {
    /*
    Brute force
    */
    private static String solve() {
        int triangleNum = 0;
        for (int i = 1; i < 100000; i++) {
            triangleNum += i;
            if (divisor(triangleNum) >= 500) {
                return Integer.toString(triangleNum);
            }
        }
        return "no result";
    }

    /**
     * find the total number of divisors of the given number
     *
     * @param num number to be calculated
     * @return number of divisors
     */
    private static int divisor(int num) {
        int count = 1;
        int sqrt = (int) Math.sqrt(num) + 1;
        for (int i = 1; i < sqrt; i++) {
            if (num % i == 0)
                count += 2;
        }
        return count;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 76576500
Process took 109ms to execute
*/