package hendrix.projectEuler.problem31_45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Problem33, Digit cancelling fractions
 *
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Problem33 {
    /*
    The problem can be simplified to the following pattern:
    ik/jk = i/j , ik/kj = i/j, ki/jk = i/j, ki/kj = i/j

    enumerate all possible fractions,
    if any fraction matches the equation above, it's considered a "digit cancelling fractions'
    */
    private static String solve() {
        //Using a String list to store the fractions
        List<String> fractions = new ArrayList<>();
        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                //for 4 digits separately
                int n1 = i / 10;
                int n2 = i % 10;
                int d1 = j / 10;
                int d2 = j % 10;
                String temp = null;
                float quotient = (float) i / j;
                if (n2 == d2 && quotient == (float) n1 / d1 && n2 != 0)       //case 1
                    temp = i + "/" + j + "=" + n1 + "/" + d1;
                else if (n2 == d1 && quotient == (float) n1 / d2 && n2 != 0)  //case 2
                    temp = i + "/" + j + "=" + n1 + "/" + d2;
                else if (n1 == d2 && quotient == (float) n2 / d1)  //case 3
                    temp = i + "/" + j + "=" + n2 + "/" + d1;
                else if (n1 == d1 && quotient == (float) n2 / d2)  //case 4
                    temp = i + "/" + j + "=" + n2 + "/" + d2;
                if (temp != null)
                    fractions.add(temp);
            }
        }
        //all matches are her at this point
        System.out.println(Arrays.toString(fractions.toArray()));
        int numerator = 1;
        int denominator = 1;
        for (String f : fractions) {
            numerator *= f.split("=")[1].charAt(0) - '0';
            denominator *= f.split("=")[1].charAt(2) - '0';
        }
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
[16/64=1/4, 19/95=1/5, 26/65=2/5, 49/98=4/8]
Answer: 8/800
Process took 62ms to execute
*/