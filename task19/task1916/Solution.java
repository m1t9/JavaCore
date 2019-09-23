package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName2));

        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();

        while (bufferedReader1.ready()) {
            list1.add(bufferedReader1.readLine().replaceAll("\n", ""));
        }
        bufferedReader1.close();
        while (bufferedReader2.ready()) {
            list2.add(bufferedReader2.readLine().replaceAll("\n", ""));
        }
        bufferedReader2.close();

        int count1 = 0;
        int count2 = 0;

        try {
            while (true) {
                if (list1.get(count1).equals(list2.get(count2))) {
                    lines.add(new LineItem(Type.SAME, list1.get(count1)));
                    count1++;
                    count2++;
                } else if (list1.get(count1).equals(list2.get(count2 + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(count2)));
                    count2++;
                } else if (list1.get(count1 + 1).equals(list2.get(count2))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(count1)));
                    count1++;
                }
            }
        } catch (Exception e) {
            if (list1.size() > count1) {
                lines.add(new LineItem(Type.REMOVED, list1.get(count1)));
            } else {
                lines.add(new LineItem(Type.ADDED, list2.get(count2)));
            }
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
