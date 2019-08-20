package hendrix.projectEuler.utils;

import java.util.LinkedList;

public class Divisor {
    public static LinkedList<Integer> findAllDivisor(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        int half = num / 2;

        for (int i = 1; i <= half; i++) {
            if (num % i == 0)
                list.add(i);
        }
        return list;
    }

    public static int findAllDivisorSum(int num) {
        LinkedList<Integer> divisors = findAllDivisor(num);
        int sum = 0;
        for (Integer i : divisors) {
            sum += i;
        }
        return sum;
    }
}
