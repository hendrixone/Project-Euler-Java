package hendrix.projectEuler.problem16_30;

import hendrix.projectEuler.utils.Permutation;

import java.util.Arrays;

/**
 * Description:
 * Problem24, Lexicographic permutations
 * <p>
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * <p>
 * 012   021   102   120   201   210
 * <p>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem24 {
    /*
    Using the utils.permutation, which is a iterator like class, to find the millionth permutation
    */
    private static String solve() {
        Permutation<Integer> p = new Permutation<>(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        int count = 0;
        Integer[] result = null;
        while (p.hasNext()) {
            count++;
            if (count == 1000000) {
                result = p.next();
                break;
            }
            p.next();
        }
        return Arrays.toString(result);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: [2, 7, 8, 3, 9, 1, 5, 4, 6, 0]
Process took 63ms to execute
*/