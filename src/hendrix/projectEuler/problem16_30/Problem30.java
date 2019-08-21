package hendrix.projectEuler.problem16_30;

/**
 * Description:
 * Problem30, Digit fifth powers
 * <p>
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <p>
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * As 1 = 14 is not a sum it is not included.
 * <p>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <p>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {
    /*
    Solution description here
    */
    private static String solve() {
        int sum = 0;
        //Enumeration
        for (int i = 2; i < 200000; i++) {
            int tempSum = 0;
            //covert to string
            String temp = String.valueOf(i);
            //get sum for 5th power of every digit
            for (int j = 0; j < temp.length(); j++) {
                tempSum += (int) Math.pow(temp.charAt(j) - '0', 5);
                if (tempSum > i) {
                    break;
                }
            }
            //if equals itself, add to the sum
            if (tempSum == i) {
                sum += i;
                System.out.println(i);
            }
        }
        return Integer.toString(sum);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 443839
Process took 42ms to execute
*/