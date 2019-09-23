package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            InputStream inputStream = new FileInputStream(reader.readLine());
            reader.close();
            BufferedInputStream buffer = new BufferedInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(buffer, StandardCharsets.UTF_8));

            ArrayList<Integer> list = new ArrayList<Integer>();

            String line;
            while ((line  = bufferedReader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }

            inputStream.close();

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



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
