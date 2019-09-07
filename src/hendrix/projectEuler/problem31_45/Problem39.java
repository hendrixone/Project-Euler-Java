package hendrix.projectEuler.problem31_45;

/**
 * Description:
 * Problem39, Integer right triangles
 * <p>
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem39 {
    /*
    pure brute force, Enumerate p and count the total number of its solutions.
    */
    private static String solve() {

        int max = 0;
        int result = 0;
        //Enumerate p
        for (int p = 1; p <= 1000; p++) {
            int count = 0;
            //a, b, c are the three sides of an triangle
            for (int a = 1; a < p / 2; a++) {
                for (int b = a; b < p / 2; b++) {
                    //if the side c, which is the hypotenuse, is whole number, a,b,c could be an solution
                    double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                    if (a + b + (int) c > p) {
                        break;
                    }
                    //if the perimeter equals p, one solution of p is found.
                    if (c % 1 == 0 && a + b + (int) c == p) {
                        count++;
                    }
                }
            }
            if (count > max) {
                max = count;
                result = p;
            }
        }
        return Integer.toString(result);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 840
Process took 1239ms to execute
*/