package hendrix.projectEuler.problem16_30;

import java.math.BigDecimal;

/**
 * Description:
 * Problem25, 1000-digit Fibonacci number
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * <p>
 * NOTE: F1 = 1 in this case.
 */
public class Problem25 {
    /*
    Since 1000 digits is undoubtedly to large for basic data type, solving this using BigInteger is quick and easy
    */
    private static String solve() {
        //Prepare the F1 and F2
        BigDecimal fn = new BigDecimal(1);
        BigDecimal prev = new BigDecimal(0);
        BigDecimal temp;

        //Count the index
        int index = 1;

        //Add all the way until it reaches 1000 digit
        while (fn.toString().length() < 1000) {
            index++;
            temp = fn;
            fn = fn.add(prev);
            prev = temp;
        }
        return Integer.toString(index);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 4782
Process took 125ms to execute
*/