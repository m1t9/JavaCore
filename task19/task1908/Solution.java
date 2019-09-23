package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader buffer = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        while (buffer.ready()) {
            String[] bufferLine = buffer.readLine().split(" ");
            for (String item : bufferLine) {
                try {
                    writer.write(Integer.parseInt(item) + " ");
                } catch (Exception e) {

                }
            }
        }
        buffer.close();
        writer.close();

    }
}
