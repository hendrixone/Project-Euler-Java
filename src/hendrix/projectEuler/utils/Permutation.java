package hendrix.projectEuler.utils;

import java.util.Arrays;

public class Permutation<E extends Comparable<? super E>> {
    private E[] list;
    private int index;
    private boolean first;

    public Permutation(E[] list) {
        this.list = list;
        first = true;
    }

    public static void main(String[] args) {
        Permutation<Integer> p = new Permutation<>(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        do {
            System.out.println(Arrays.toString(p.next()));
        } while (p.hasNext());
    }

    public boolean hasNext() {
        if (list.length <= 1)
            return false;

        index = list.length - 1;
        while (index > 0) {
            index--;
            if (list[index].compareTo(list[index + 1]) < 0) {
                return true;
            }
        }
        return false;
    }

    public E[] next() {
        if (first) {
            first = false;
            return list;
        }
        int k = list.length - 1;
        while (list[k].compareTo(list[index]) <= 0)
            k--;
        swap(k, index);
        Arrays.sort(list, index + 1, list.length);
        return list;
    }

    private void swap(int k, int i) {
        E temp = list[k];
        list[k] = list[i];
        list[i] = temp;
    }

}
