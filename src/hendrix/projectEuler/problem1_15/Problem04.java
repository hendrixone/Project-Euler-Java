package hendrix.projectEuler.problem1_15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 * Problem04, NAME
 * INFO
 */
public class Problem04 {
    /*
    Enumerate all possibilities, and return the largest result in the result set
    */
    private static String solve() {
        //list to hold result
        List<Integer> result = new ArrayList<>();
        //enumerate all possibilities, 1000000 times
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                //covert to string for easier access to each digit
                String num = Integer.toString(i * j);
                boolean flag = true;
                for (int k = 0; k < num.length() / 2; k++) {
                    if (num.charAt(k) != num.charAt(num.length() - k - 1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    result.add(Integer.parseInt(num));

            }
        }

        result.sort(Comparator.naturalOrder());

        return Integer.toString(result.get(result.size() - 1));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 906609
Process took 170ms to execute
*/