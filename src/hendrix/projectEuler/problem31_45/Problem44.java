package hendrix.projectEuler.problem31_45;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Description:
 * Problem44, Pentagon numbers
 *
 * Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2. The first ten pentagonal numbers are:
 *
 * 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
 *
 * It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their difference, 70 − 22 = 48, is not pentagonal.
 *
 * Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised; what is the value of D?
 */
public class Problem44 {
    /*
    Brute force
    */
    private static String solve() {
        //A hashSer is used to determine the pentagons
        HashSet<Long> pentagons = new HashSet<>();
        //A list is used to store pentagons in order
        ArrayList<Long> list = new ArrayList<>();
        int upperBoud = 5000;
        //Initialize
        for (int i = 1; i <= upperBoud; i++) {
            list.add(pentagon(i));
        }
        for (int i = 1; i <= upperBoud * 2; i++) {
            pentagons.add(pentagon(i));
        }

        long min = Long.MAX_VALUE;
        //A double for loop is used to enumerate all possibilities
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                long sum = list.get(i) + list.get(j);
                if(pentagons.contains(sum)) {
                    long diff = list.get(j) - list.get(i);
                    if(pentagons.contains(diff) && diff < min)
                        min = diff;
                }
            }
        }
        return Long.toString(min);
    }

    private static long pentagon(long n){
        return (((3 * n) -1) * n) / 2;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 5482660
Process took 361ms to execute
*/