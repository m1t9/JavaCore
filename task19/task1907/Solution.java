package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader buffer = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        int count = 0;
        while (buffer.ready()) {
            String[] bufferLine = buffer.readLine().split("\\W");
            for (String line : bufferLine) {
                if (line.equals("world"))
                    count++;
            }
        }
        buffer.close();

        System.out.println(count);

    }
}
