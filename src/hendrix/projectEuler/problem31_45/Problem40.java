package hendrix.projectEuler.problem31_45;

/**
 * Description:
 * Problem40, Champernowne's constant
 * <p>
 * An irrational decimal fraction is created by concatenating the positive integers:
 * <p>
 * 0.123456789101112131415161718192021...
 * <p>
 * It can be seen that the 12th digit of the fractional part is 1.
 * <p>
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 * <p>
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem40 {
    /*
    Solution description here
    */
    private static String solve() {
        //Can be solve using list easily
        //init a list
        StringBuilder list = new StringBuilder();
        int n = 1;
        while (list.length() <= 1000000) {
            list.append(n++);
        }
        //find the product
        int product = 1;
        int i = 1;
        while (i <= 1000000) {
            product *= list.charAt(i - 1) - '0';
            i *= 10;
        }
        return Integer.toString(product);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 210
Process took 25ms to execute
*/