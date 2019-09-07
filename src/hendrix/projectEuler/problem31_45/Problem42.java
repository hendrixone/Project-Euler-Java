package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.CommonTools;
import hendrix.projectEuler.utils.TextImporter;

import java.io.IOException;
import java.util.HashSet;

/**
 * Description:
 * Problem42, Coded triangle numbers
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 * <p>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <p>
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
 * <p>
 * Using p42.txt.txt (in externalfile folder), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 */
public class Problem42 {
    /*
    No special tricks about this problem,
    just using HashSet for faster check.
    */
    private static String solve() {
        //Import names from txt file
        String[] names;
        try {
            names = TextImporter.readString("p42.txt");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        //Store the first 50 triangle number in a hashSet to reduce the time of checking a triangle number to O(1)
        HashSet<Integer> triangleNums = new HashSet<>();
        for (int i = 1; i < 50; i++) {
            int temp = (int) (0.5 * i * (i + 1));
            triangleNums.add(temp);
        }

        //Calculate the word value and count the triangle number
        int count = 0;
        for (String name : names) {
            int value = CommonTools.wordValue(name);
            if (triangleNums.contains(value)) {
                count++;
            }
        }

        return Integer.toString(count);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 162
Process took 72ms to execute
*/