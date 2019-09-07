package hendrix.projectEuler.problem1_15;

/**
 * Description:
 * Problem15, Lattice paths
 * <p>
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * (visit official website for the image description)
 * How many such routes are there through a 20×20 grid?
 */
public class Problem15 {
    /*
    Composite math
    */
    private static String solve() {
        long[][] grid = new long[21][21];

        for (int i = 0; i < 21; i++) {
            grid[0][i] = 1;
            grid[i][0] = 1;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }


        return Long.toString(grid[20][20]);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 137846528820
Process took 0ms to execute
*/