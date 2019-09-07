package hendrix.projectEuler.utils;

import java.util.Arrays;
import java.util.LinkedList;

public class Digits{
    private final LinkedList<Byte> list;

    public Digits(int num) {
        list = toList(num);
    }

    public Digits() {
        list = new LinkedList<>();
    }

    public Digits(byte[] digits) {
        this.list = new LinkedList<>();
        for (byte digit : digits) {
            this.list.add(digit);
        }
    }

    public Digits(Byte[] digits) {
        this.list = new LinkedList<>();
        list.addAll(Arrays.asList(digits));
    }

    public Digits(LinkedList<Byte> linkedList){
        this.list = linkedList;
    }

    public static long longValueOf(byte[] array){
        long temp = 0;
        for (byte b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    public static long longValueOf(int[] array) {
        long temp = 0;
        for (int b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    public static long longValueOf(Integer[] array) {
        long temp = 0;
        for (int b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    public static long longValueOf(Byte[] array) {
        long temp = 0;
        for (Byte b : array) {
            temp *= 10;
            temp += b;
        }
        return temp;
    }

    public static long longValueOf(LinkedList<Byte> list){
        long temp = 0;
        for (Byte aByte : list) {
            temp *= 10;
            temp += aByte;
        }
        return temp;
    }

    public long value() {
        return longValueOf(this.list);
    }

    static public LinkedList<Byte> toList(int num) {
        LinkedList<Byte> list = new LinkedList<>();
        while(num != 0){
            list.addFirst((byte) (num % 10));
            num /= 10;
        }
        return list;
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
        LinkedList<Byte> temp = new LinkedList<>();
        for (Byte aByte : list) {
            temp.addFirst(aByte);
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

    public LinkedList<Byte> getList() {
        return list;
    }

    @Override
    public String toString() {
        return Arrays.toString(list.toArray());
    }

    public int length() {
        return list.size();
    }

    public Digits truncateLEft() {
        LinkedList temp = (LinkedList) list.clone();
        temp.removeFirst();
        return new Digits(temp);
    }

    public Digits truncateRight() {
        LinkedList temp = (LinkedList) list.clone();
        temp.removeLast();
        return new Digits(temp);
    }

    public Digits trim(int from, int to) {
        LinkedList temp = (LinkedList) list.clone();
        int len = list.size() - to - 1;
        for (int i = 0; i < len; i++) {
            temp.removeLast();
        }
        for (int i = 0; i < from; i++) {
            temp.removeFirst();
        }
        return new Digits(temp);
    }

    public int sum() {
        int temp = 0;
        for (byte b : list) {
            temp += b;
        }
        return temp;
    }

    public Digits concat(Digits d) {
        LinkedList<Byte> temp = (LinkedList<Byte>) list.clone();
        temp.addAll(d.list);
        return new Digits(temp);
    }

    public boolean isPandigital() {
        Object[] temp = list.toArray();
        Arrays.sort(temp);
        for (byte i = 1; i < temp.length; i++) {
            if ((Byte)temp[i - 1] != i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Digits.lengthOf(1234));
        Digits d = new Digits(123);
        System.out.println(d.length());
        System.out.println(d);
        System.out.println(d.truncateLEft());
        System.out.println(d.truncateRight());
        System.out.println(d.getList());
        System.out.println(d.value());
        System.out.println(d.invert());
        System.out.println(d);
        System.out.println(d.isPandigital());
        System.out.println(d.concat(new Digits(123)));
    }

}
