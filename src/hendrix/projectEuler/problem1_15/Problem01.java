package hendrix.projectEuler.problem1_15;

/**
 * Description:
 *
 * Problem 1, Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem01 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: "+result+"\nProcess took "+(endTime - startTime)/1000+"ms to execute");
    }

    private static String solve() {
        int sum = 0;
        for(int i = 1; i < 1000;i++) {
            if(i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return Integer.toString(sum);
    }
}
/*
Answer: 233168
Process took 47ms to execute
 */