package hendrix.projectEuler.problem1_15;

/**
 * Description:
 * Problem03, Largest prime factor
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem03 {
    /*
    Divide the given number util it's a prime number and the final number is the answer
    */
    private static String solve() {
        long number = 600851475143L;
        int i = 1;
        while (number > 1) {
            if (number % ++i == 0)
                number /= i;
        }
        return Integer.toString(i);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (100 * 1000) + "ms to execute");
    }
}
/*
Answer: 6857
Process took 3ms to execute
*/