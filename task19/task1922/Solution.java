package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(fileName));

        int count = 0;
        while (bufferedReader.ready()) {
            String lineString = bufferedReader.readLine();
            String[] line = lineString.split(" ");
//            System.out.println(lineString);
//            for (String l : line)
//                System.out.println(l);

            for (String valueWords : words) {
                if (Arrays.asList(line).contains(valueWords))
                    count++;
            }
            if (count == 2)
                System.out.println(lineString);
            count = 0;
        }
        bufferedReader.close();

    }
}
