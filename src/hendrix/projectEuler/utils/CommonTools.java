package hendrix.projectEuler.utils;

public class CommonTools {
    public static boolean isPalindromes(int n) {
        int n1 = n, n2 = 0;
        while (n1 != 0) {
            n2 = n2 * 10 + n1 % 10;
            n1 /= 10;
        }
        return n == n2;
    }

    public static boolean isPalindromes(String num) {
        int len = num.length() / 2;
        for (int i = 0; i < len; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static int getDigitsLength(int n) {
        n = n > 0 ? n : -n;
        return n == 0 ? 1 : (int) Math.log10(n) + 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromes(123321));
        System.out.println(isPalindromes("12321"));
        System.out.println(getDigitsLength(12321));
    }

}
