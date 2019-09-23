package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new TreeSet<String>();

        String fileName;
        while (!(fileName = bufferedReader.readLine()).equals("end")) {
            set.add(fileName);
        }
        bufferedReader.close();


        String outputFileName = ((TreeSet<String>) set).first();
        outputFileName = outputFileName.substring(0, outputFileName.indexOf(".part1"));

        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName, true);

        for (String name : set) {
            FileInputStream inputStream = new FileInputStream(name);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            for (byte symbol : buffer) {
                fileOutputStream.write(symbol);
            }
            inputStream.close();
        }
        fileOutputStream.close();

    }
}
