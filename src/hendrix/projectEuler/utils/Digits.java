package hendrix.projectEuler.utils;

import java.util.Arrays;

public class Digits {
    private byte[] digits;

    public Digits(int num) {
        digits = toArray(num);
    }

    public Digits() {
        digits = new byte[0];
    }

    public Digits(byte[] digits) {
        this.digits = digits;
    }

    public Digits(Byte[] list) {
        this.digits = new byte[list.length];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = list[i];
        }
    }

    public static int intValueOf(byte[] array) {
        int temp = 0;
        for (byte b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    public static int intValueOf(int[] array) {
        int temp = 0;
        for (int b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    public static int intValueOf(Integer[] array) {
        int temp = 0;
        for (int b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    public static int intValueOf(Byte[] array) {
        int temp = 0;
        for (Byte b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    static public byte[] toArray(int num) {
        byte[] array = new byte[Digits.lengthOf(num)];
        for (int i = 0; i < array.length; i++) {
            array[array.length - i - 1] = (byte) (num % 10);
            num /= 10;
        }
        return array;
    }

    public static int lengthOf(long num) {
        int length = 0;
        while (num != 0) {
            num /= 10;
            length++;
        }
        return length;
    }

    public Digits invert() {
        byte[] temp = new byte[digits.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = digits[temp.length - 1 - i];
        }
        return new Digits(temp);
    }

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

    public static void main(String[] args) {
        System.out.println(Digits.lengthOf(1234));
        Digits d = new Digits(123);
        System.out.println(d.length());
        System.out.println(d);
        System.out.println(Arrays.toString(d.truncateLEft().getDigits()));
        System.out.println(d.truncateRight());
        System.out.println(Arrays.toString(d.getDigits()));
        System.out.println(d.intValue());
        System.out.println(d.invert());
        System.out.println(d.isPandigital());
        System.out.println(d.concat(new Digits(123)));
    }

    public byte[] getDigits() {
        return digits;
    }

    @Override
    public String toString() {
        return Arrays.toString(digits);
    }

    public int length() {
        return digits.length;
    }

    public Digits truncateLEft() {
        if (digits.length < 1)
            return this;
        byte[] temp = new byte[digits.length - 1];
        System.arraycopy(digits, 1, temp, 0, temp.length);
        return new Digits(temp);
    }

    public Digits truncateRight() {
        if (digits.length < 1)
            return this;
        byte[] temp = new byte[digits.length - 1];
        System.arraycopy(digits, 0, temp, 0, temp.length);
        return new Digits(temp);
    }

    public Digits trim(int from, int to) {
        byte[] temp = new byte[to - from + 1];
        for (int i = from, k = 0; i <= to; i++, k++) {
            temp[k] = digits[i];
        }
        return new Digits(temp);
    }

    public int intValue() {
        return intValueOf(digits);
    }

    public long longValue() {

    }

    public int sum() {
        int temp = 0;
        for (byte b : digits) {
            temp += b;
        }
        return temp;
    }

    public Digits concat(Digits d) {
        byte[] temp = Arrays.copyOf(this.digits, length() + d.length());
        for (int i = 0; i < d.length(); i++) {
            temp[i + digits.length] = d.digits[i];
        }
        return new Digits(temp);
    }

    public boolean isPandigital() {
        byte[] temp = Arrays.copyOf(digits, digits.length);
        Arrays.sort(temp);
        for (byte i = 1; i < temp.length; i++) {
            if (temp[i - 1] != i)
                return false;
        }
        return true;
    }

}
