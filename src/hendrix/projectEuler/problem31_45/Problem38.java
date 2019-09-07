package hendrix.projectEuler.problem31_45;

import hendrix.projectEuler.utils.Digits;

/**
 * Description:
 * Problem38, Pandigital multiples
 * <p>
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <p>
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
 * <p>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * <p>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class Problem38 {
    /*
    Limit the upper bound of the number under 5 digit will help improve speed, no other special tricks
    */
    private static String solve() {
        int max = 0;
        for (int i = 1; i < 10000; i++) {
            Digits temp = new Digits();
            for (int j = 1; j < 100; j++) {
                temp = temp.concat(new Digits(i * j));
                if (temp.length() > 9)
                    break;
                if (temp.length() == 9 && temp.intValue() > max && temp.isPandigital()) {
                    max = temp.intValue();
                    System.out.println(max);
                }
            }
        }
        return Integer.toString(max);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 932718654
Process took 20ms to execute
*/