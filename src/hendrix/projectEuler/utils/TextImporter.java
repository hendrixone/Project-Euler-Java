package hendrix.projectEuler.utils;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextImporter {
    public static String read(String name) throws IOException {
            BufferedReader br = getReader(name);
            String content = "";
            String temp;
            while ((temp = br.readLine()) != null) {
                content = content.concat(temp);
            }
            br.close();
            return content;
    }

    public static String[] readWithLine(String name) throws IOException {
            BufferedReader br = getReader(name);
            LinkedList<String> content = new LinkedList<>();
            String temp;
            while ((temp = br.readLine()) != null) {
                content.add(temp);
            }
            br.close();

            String[] array = new String[content.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = content.pop();
            }
            return array;
    }

    public static String[] readString(String name) throws IOException {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(read(name));
        LinkedList<String> temp = new LinkedList<>();
        while (m.find())
            temp.add(m.group());
        String[] list = new String[temp.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = temp.pop();
        }
        return list;
    }

    public static int[][] readIntTable(String name) throws IOException {
        String[] raw = readWithLine(name);
        int[][] table = new int[raw.length][];
        for (int i = 0; i < raw.length; i++) {
            String[] temp = raw[i].split(" ");
            int[] line = new int[temp.length];
            for (int j = 0; j < temp.length; j++) {
                line[j] = Integer.parseInt(temp[j]);
            }
            table[i] = line;
        }
        return table;
    }

    private static BufferedReader getReader(String path) throws FileNotFoundException {
        path = "externalfile/" + path;
        File file = new File(path);
        return new BufferedReader(new FileReader(file));
    }

    public static void main(String[] args) throws IOException {
        String[] list = readString("p23.txt");
        for (String s : list)
            System.out.println(s);
    }
}
