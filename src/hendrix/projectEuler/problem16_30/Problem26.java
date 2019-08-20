package hendrix.projectEuler.problem16_30;

import java.util.ArrayList;

/**
 * Description:
 * Problem26, Reciprocal cycles
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 * <p>
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 * <p>
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Problem26 {
    /*
    The trick here is don't try to find repeats in the decimals, but to look for repeated dividend.

    if the dividend repeated, the decimals will repeat from where that remainder first appear, thus,
    using a list to store all remainder and check if the remainder ever appeared in the list. If so,
    take the total number of all remainder and minus the index of the repeated remainder to get the
    length of repeated decimals
    */
    private static String solve() {
        //store the maximum d
        int max = 0;
        int d = 0;

        //enumerate all d in (1,1000)
        for (int i = 2; i < 1000; i++) {
            //get the number of repeated decimals, will receive 0 if no decimal repeated
            int temp = findRepeat(i);
            if (temp > max) {
                max = temp;
                d = i;
            }
        }
        return Integer.toString(d);
    }

    private static int findRepeat(int i) {
        //list to store remainders
        ArrayList<Integer> dividends = new ArrayList<>();
        int dividend = 1;
        //calculate more decimal until repetition detected or remainder = 0
        while (true) {
            if (dividend < i) {
                //get new dividend
                dividend *= 10;
                //check if dividend appeared before
                for (int j = 0; j < dividends.size(); j++) {
                    if (dividends.get(j).equals(dividend))
                        return dividends.size() - j - 1;
                }
                //add new dividend to list
                dividends.add(dividend);
                //remainder = 0
            } else if (dividend % i == 0)
                return 0;
            else
                dividend %= i;

        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 983
Process took 114ms to execute
*/