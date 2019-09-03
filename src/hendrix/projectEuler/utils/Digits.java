package hendrix.projectEuler.utils;

import java.util.Arrays;

public class Digits {
    private byte[] digits;

    public Digits(int num) {
        digits = getDigitsArray(num);
    }

    public Digits() {
    }

    public Digits(byte[] digits) {
        this.digits = digits;
    }

    public static int toInt(byte[] array) {
        int temp = 0;
        for (byte b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    static public byte[] getDigitsArray(int num) {
        byte[] array = new byte[CommonTools.getDigitsLength(num)];
        for (int i = 0; i < array.length; i++) {
            array[array.length - i - 1] = (byte) (num % 10);
            num /= 10;
        }
        return array;
    }

    public static void main(String[] args) {
        Digits d = new Digits(123456);
        System.out.println(d.getLength());
        System.out.println(d);
        System.out.println(Arrays.toString(d.truncateLEft().getDigits()));
        System.out.println(d.truncateRight());
        System.out.println(Arrays.toString(d.getDigits()));
        System.out.println(d.getValue());
        System.out.println(d.invert());
    }

    public int getLength() {
        return digits.length;
    }

    public Digits invert() {
        byte[] temp = new byte[digits.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = digits[temp.length - 1 - i];
        }
        return new Digits(temp);
    }

    public Digits truncateLEft() {
        byte[] temp = new byte[digits.length - 1];
        System.arraycopy(digits, 1, temp, 0, temp.length);
        return new Digits(temp);
    }

    public Digits truncateRight() {
        byte[] temp = new byte[digits.length - 1];
        System.arraycopy(digits, 0, temp, 0, temp.length);
        return new Digits(temp);
    }

    public byte[] getDigits() {
        return digits;
    }

    @Override
    public String toString() {
        return Arrays.toString(digits);
    }

    public int getValue() {
        return toInt(digits);
    }
}
