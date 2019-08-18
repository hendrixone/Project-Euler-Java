package hendrix.projectEuler.problem1_15;

/**
 * Description:
 * Problem09, Special Pythagorean triplet
 * <p>
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem09 {
    /*
    Brute force works here
    */
    private static String solve() {
        int a;
        int b;
        int c;
        for (a = 1, b = 1, c = 0; a < 400; b++) {
            c = (int) Math.sqrt((a * a) + (b * b));
            if (a + b + c == 1000) {
                if (Math.sqrt(a * a + b * b) % 1 == 0.0) {
                    return Integer.toString(a * b * c);
                }
            }
            if (a + b + c > 1000 || b > 400) {
                c = 0;
                a++;
                b = a;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 31875000
Process took 3ms to execute
*/