package hendrix.projectEuler.problem16_30;

/**
 * Description:
 * Problem17, Number letter counts
 * <p>
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
public class Problem17 {
    /*
    Could be done with paper, but this solution miss-calculated one character causing the result to be one less than the correct answer
    No clue;
    */
    private static String solve() {
        //one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty thirty forty fifty sixty seventy eighty ninety
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += getOnes(i);
        }
        return Integer.toString(sum);
    }

    static int getOnes(int num) {
        if (num < 10) {
            switch (num) {
                case 1:
                case 6:
                case 2:
                    return 3;
                case 3:
                case 8:
                case 7:
                    return 5;
                case 4:
                case 9:
                case 5:
                    return 4;
                default:
                    return 0;
            }
        } else {
            return get10s(num);
        }
    }

    static int get10s(int num) {
        if (num < 20) {
            switch (num) {
                case 11:
                case 12:
                    return 6;
                case 13:
                case 19:
                case 18:
                case 14:
                    return 8;
                case 15:
                case 16:
                    return 7;
                case 17:
                    return 9;
                default:
                    return 3;
            }
        } else {
            return get20s(num);
        }
    }

    static int get20s(int num) {
        if (num < 100) {
            switch (num / 10) {
                case 2:
                case 9:
                case 8:
                case 3:
                    return 6 + getOnes(num % 10);
                case 4:
                case 6:
                case 5:
                    return 5 + getOnes(num % 10);
                case 7:
                    return 7 + getOnes(num % 10);
            }
        } else {
            return get100s(num);
        }
        return 0;
    }

    static int get100s(int num) {
        if (num % 100 == 0) {
            return getOnes(num / 100) + 7;
        } else {
            switch (num / 100) {
                case 1:
                case 2:
                case 6:
                    return 10 + getOnes(num % 100) + 3;
                case 3:
                case 7:
                case 8:
                    return 12 + getOnes(num % 100) + 3;
                case 4:
                case 5:
                case 9:
                    return 11 + getOnes(num % 100) + 3;
                default:
                    return 11;
            }
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
Answer: 21123
Process took 0ms to execute
*/