package hendrix.projectEuler.utils;

public class CommonTools {

    public static int wordValue(String word) {
        word = word.toUpperCase();
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i) - 'A' + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(wordValue("SKY"));
    }

}
