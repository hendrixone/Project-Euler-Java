package hendrix.projectEuler.problem16_30;

/**
 * Description:
 * Problem18, Maximum path sum I
 * <p>
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * <p>
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom of the triangle below (p18.txt):

 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class Problem18_TODO {
    /*
    Solution description here
    */
    private static String solve() {
//        String[] raw = TextImporter.readWithLine("p18.txt");
//        int[][] table = new int[raw.length][];
//        for (int i = 0; i < raw.length; i++) {
//            String[] temp = raw[i].split(" ");
//            int[] line = new int[temp.length];
//            for (int j = 0; j < temp.length; j++) {
//                line[j] = Integer.parseInt(temp[j]);
//            }
//            table[i] = line;
//        }
//        for (int i = 0; i < table.length; i++) {
//            System.out.println(Arrays.toString(table[i]));
//        }
//        int max;
//        for (int i = 0; i <= 0b11111111111111; i++) {
//            int sum;
//            String path = Integer.toBinaryString(i);
//            for (int j = 0; j < 14; j++) {
//
//            }
//        }
        return "Answer Here";
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Put result here
*/