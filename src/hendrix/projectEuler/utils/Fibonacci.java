package hendrix.projectEuler.utils;

import java.util.List;

public class Fibonacci {
    private int[] array;
    private Fibonacci(){
    }


    public static Fibonacci initByCount(int count){
        Fibonacci fib = new Fibonacci();
        int [] temp = new int[count];
        temp[0] = 0;
        temp[1] = 1;
        for (int i = 2; i < temp.length; i++) {
            temp[i] = temp[i-1] + temp[i-2];
        }
        fib.array = temp;

        return fib;
    }

    public static Fibonacci initByMax(int max){
        Fibonacci fib = new Fibonacci();
        return null;
    }
}
