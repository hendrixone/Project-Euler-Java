package hendrix.projectEuler.problem1_15;

/**
 * Description:
 * Problem06, Sum square difference
 * <p>
 * The sum of the squares of the first ten natural numbers is,
 * <p>
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem06 {
    /*
    Simple solution, number is stored using long type.
    */
    private static String solve() {
        long tStart = System.currentTimeMillis();

        long sum = 0;
        long sumOfSquare = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            sumOfSquare += (i * i);
        }

        return Long.toString((sum * sum) - sumOfSquare);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 25164150
Process took 0ms to execute
*/