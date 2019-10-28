package hendrix.projectEuler.utils;

import java.util.Arrays;
import java.util.LinkedList;

public class Combination{
    private int length;
    private int maxCombs;
    private Object[] list;
    private int index;

    public Combination(Object[] list) {
        this.list = list;
        length = list.length;
        maxCombs = 1 << length;
        index = 1;
    }

    public boolean hasNext(){
        return index < maxCombs;
    }

    public Object[] next(){
        LinkedList<Object> result = new LinkedList<>();
        int temp = index;
        for (int i = 0; i < length; i++) {
            if((temp & 1) == 1){
                result.add(list[i]);
            }
            temp >>= 1;
        }
        index++;
        Object[] array = new Object[result.size()];
        int len = result.size();
        for (int i = 0; i < len; i++) {
            array[i] = result.pop();
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{1,2,3,4,5};
        Combination combination = new Combination(list);
        while(combination.hasNext()){
            System.out.println(Arrays.toString(combination.next()));
        }
    }
}
