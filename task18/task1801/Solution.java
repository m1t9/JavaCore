package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        int max = 0;
        int num = 0;

        while (inputStream.available() > 0) {
            if ((num = inputStream.read()) > max)
                max = num;
        }
        inputStream.close();

        System.out.println(max);

    }
}
