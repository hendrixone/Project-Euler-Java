package hendrix.projectEuler.problem16_30;

import hendrix.projectEuler.utils.TextImporter;

import java.io.IOException;
import java.util.Arrays;

/**
 * Description:
 * Problem22, Names scores
 * Using p22.txt, a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */
public class Problem22 {
    /*
    Nothing special
    */
    private static String solve() throws IOException {
        int sum = 0;
        //load names into an array
        String[] nameList = TextImporter.readString("p22.txt");
        Arrays.sort(nameList);

        //calculate name score for each name and add to the sum;
        for (int i = 0; i < nameList.length; i++) {
            int temp = 0;
            for (int j = 0; j < nameList[i].length(); j++) {
                temp += nameList[i].charAt(j) - 'A' + 1;
            }
            temp *= i + 1;
            sum += temp;
        }
        return Integer.toString(sum);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 871198282
Process took 21ms to execute
*/