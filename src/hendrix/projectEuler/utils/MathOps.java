package hendrix.projectEuler.utils;

public class MathOps {
    /**
     * calculate the factorial of a number
     *
     * @param num an int
     * @return its factorial
     */
    public static int factorial(int num) {
        if (num < 0) return 0;
        if (num == 0) return 1;
        int temp = 1;
        while (num > 1)
            temp *= num--;
        return temp;
    }
}
