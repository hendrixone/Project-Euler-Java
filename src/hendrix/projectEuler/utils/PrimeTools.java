package hendrix.projectEuler.utils;

import java.util.LinkedList;

public class PrimeTools {

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        for (int prime : primes) {
            if (num == prime)
                return true;
            if (num % prime == 0) {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i < sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void initByCount(int count) {
        //TODO
    }

    private static boolean[] initByMax(int max) {
        boolean[] boolList = new boolean[max];
        for (int i = 2; i < boolList.length; i++)
            boolList[i] = true;

        int sqrt = (int) Math.sqrt(boolList.length) + 1;
        for (int i = 0; i < sqrt + 1; i++) {
            if (boolList[i]) {
                for (int j = i + 1; j < boolList.length; j++) {
                    if (j % i == 0)
                        boolList[j] = false;
                }
            }
        }
        return boolList;
    }

    public static boolean[] getBoolArray(int max) {
        return initByMax(max);
    }

    public static int[] getArray(int max) {
        boolean[] boolList = initByMax(max);
        LinkedList<Integer> temp = new LinkedList<>();
        for (int i = 0; i < boolList.length; i++) {
            if (boolList[i]) {
                temp.add(i);
            }
        }
        int[] list = new int[temp.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = temp.pop();
        }
        return list;
    }
}
