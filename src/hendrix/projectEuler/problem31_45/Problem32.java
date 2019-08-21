package hendrix.projectEuler.problem31_45;

import java.util.HashSet;

/**
 * Description:
 * Problem32, Pandigital products
 * <p>
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * <p>
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * <p>
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * <p>
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Problem32 {
    /*
    Brute Force, the enumeration of multiplicands don't necessarily need to go up to 9 digit. In fact ,4 digit is enough [1,10000).

    */
    private static String solve() {
        //HashSet is used to store products in order to remove duplicated numbers
        HashSet<Integer> productList = new HashSet<>();
        //Enumeration
        for (int i = 1; i < 10000; i++) {
            for (int j = i + 1; j < 10000; j++) {
                int product = i * j;
                //convert all digits into string
                String temp = i + "" + j + "" + product;
                //optimization
                if (temp.length() > 9)
                    break;
                if (temp.length() != 9)
                    continue;
                //check if is pandigital
                if (isPandigital(temp)) {
                    productList.add(product);
                    System.out.println(i + " * " + j + " = " + product);
                }

            }
        }
        int sum = 0;
        for (int i : productList) {
            sum += i;
        }
        return Integer.toString(sum);
    }

    private static boolean isPandigital(String num) {
        //try to find every number through 1-9 in the String passed in
        for (char c = '1'; c <= '9'; c++) {
            if (num.indexOf(c) == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 45228
Process took 29ms to execute
*/