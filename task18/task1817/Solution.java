package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int spaceCount = 0, symbolCount = fileInputStream.available();

        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 32) {
                spaceCount++;
            }
        }

        fileInputStream.close();

        System.out.println(String.format("%.2f", (double) spaceCount/ (double) symbolCount * 100.));


    }
}
