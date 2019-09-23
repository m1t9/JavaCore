package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class solution0 {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            File file = new File(reader.readLine());
            reader.close();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<Integer> list = new ArrayList<Integer>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }

            Collections.sort(list);
            int count = 0;
            while (count < list.size()) {
                if (list.get(count) % 2 != 0) {
                    list.remove(count);
                } else {
                    count++;
                }

            }

            for (int i : list) {
                System.out.println(i);
            }

            fileReader.close();
            bufferedReader.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
