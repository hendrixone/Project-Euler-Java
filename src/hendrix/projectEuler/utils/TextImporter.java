package hendrix.projectEuler.utils;

import java.io.*;
import java.util.LinkedList;

public class TextImporter {
    public static String read(String name) {
        try {
            BufferedReader br = getReader(name);
            String content = "";
            String temp;
            while ((temp = br.readLine()) != null) {
                content = content.concat(temp);
            }
            br.close();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] readWithLine(String name) {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int[][] readIntTable(String name) {
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

    private static BufferedReader getReader(String path) {
        path = "externalfile/" + path;
        File file = new File(path);
        try {
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] list = readWithLine("p08.txt");
        for (String s : list)
            System.out.println(s);
    }
}
