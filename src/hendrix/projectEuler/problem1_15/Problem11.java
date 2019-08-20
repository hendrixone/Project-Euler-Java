package hendrix.projectEuler.problem1_15;

import hendrix.projectEuler.utils.TextImporter;

import java.io.IOException;

/**
 * Description:
 * Problem11, Largest product in a grid
 * <p>
 * In the 20×20 grid (p11), four numbers along a diagonal line have been marked in red.
 * <p>
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * <p>
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
 */
public class Problem11 {
    /*
    Covert into a two dimension array then find the max from 4 different path
    */
    private static String solve() throws IOException {
        String[] raw = TextImporter.readWithLine("p11.txt");
        int[][] table = new int[20][20];
        for (int i = 0; i < raw.length; i++) {
            String[] temp = raw[i].split(" ");
            for (int j = 0; j < temp.length; j++) {
                table[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int max = 0;
        //find the max from all possible outcome using four different path
        //cross
        for (int i = 0, k = 0; i < 20; k++) {
            if (k == 17) {
                k = -1;
                i++;
                continue;
            }
            int product = table[i][k] * table[i][k + 1] * table[i][k + 2] * table[i][k + 3];
            if (product > max)
                max = product;
        }
        //down
        for (int i = 0, k = 0; i < 17; k++) {
            if (k == 20) {
                k = -1;
                i++;
                continue;
            }
            int product = table[i][k] * table[i + 1][k] * table[i + 2][k] * table[i + 3][k];
            if (product > max)
                max = product;
        }
        //top_right--bot_left/
        for (int i = 0, k = 3; i < 17; k++) {
            if (k == 20) {
                k = 2;
                i++;
                continue;
            }
            int product = table[i][k] * table[i + 1][k - 1] * table[i + 2][k - 2] * table[i + 3][k - 3];
            if (product > max)
                max = product;
        }
        //top_left--bot_right\
        for (int i = 0, k = 0; i < 17; k++) {
            if (k == 17) {
                k = -1;
                i++;
                continue;
            }
            int product = table[i][k] * table[i + 1][k + 1] * table[i + 2][k + 2] * table[i + 3][k + 3];
            if (product > max)
                max = product;
        }

        return Integer.toString(max);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 70600674
Process took 9ms to execute
*/