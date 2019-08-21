package hendrix.projectEuler.problem16_30;

/**
 * Description:
 * Problem28, Number spiral diagonals
 * <p>
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Problem28 {
    /*
    Instead of generate a spiral width of 1000, this problem can be solve by finding the pattern of the diagonal number which is:
        this number on the top right diagonal are the square of the number of spiral multiplied by 2 and minus 1, and, going counter-clockwise, the number on
        the diagonal is decreased by the number of the spiral minus 1 and multiply by 2. Ex: 1, 9, 25 and 1, 9-(2-1)*2 = 7, 25-(3-1)*2 = 21.....

    by breaking down this problem into pure formula, the runtime has been reduced to less than a millisecond (4.7GHz processor)
    */
    private static String solve() {
        //store four diagonal line into a 4 array, in the order of tr, tl, bl, br
        int[][] diagonals = new int[502][];
        //go through all numbers on 4 diagonals
        for (int i = 2; i < diagonals.length; i++) {
            int[] temp = new int[4];
            for (int j = 0; j < temp.length; j++) {
                //formula declared above
                temp[j] = (int) Math.pow(i * 2 - 1, 2) - j * ((i - 1) * 2);
            }
            diagonals[i] = temp;
        }
        //calculate sum
        int sum = 1;
        for (int i = 2; i < diagonals.length; i++) {
            for (int j = 0; j < diagonals[i].length; j++) {
                sum += diagonals[i][j];
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
Answer: 669171001
Process took 0ms to execute
*/