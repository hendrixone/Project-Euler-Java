package hendrix.projectEuler.utils;

import java.util.Iterator;
import java.util.LinkedList;

public class Fibonacci {
    private static LinkedList<Integer> list;

    private Fibonacci() {
    }

    /**
     * Initialize list with 0 and 1
     */
    private static void init() {
        list = new LinkedList<>();
        list.add(0);
        list.add(1);
    }

    /**
     * generate the given amount of fibonacci number
     *
     * @param count number to be generated
     */
    public static void initByCount(int count) {
        init();
        while (list.size() < count) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }
    }

    /**
     * Generate a sequence of fibonacci number which only the last number exceed the max
     *
     * @param max
     */
    public static void initByMax(int max) {
        init();
        while (list.getLast() < max) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }
    }

    /**
     * Return an int[] array representation of the fibonacci sequence
     *
     * @return
     */
    public static int[] toArray() {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * return a Integer iterator of the sequence
     *
     * @return
     */
    public static Iterator<Integer> integerIterator() {
        return list.listIterator();
    }

    public static void main(String[] args) {
        Fibonacci.initByMax(1000);
        int[] list = Fibonacci.toArray();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        Iterator<Integer> iterator = Fibonacci.integerIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
