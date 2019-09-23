package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fieName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        FileReader reader = new FileReader(fieName1);
        FileWriter writer = new FileWriter(fileName2);

        int count = 1;
        while (reader.ready()) {
            int data = reader.read();
            if (count % 2 == 0) {
                writer.write(data);
            }
            count++;
        }

        reader.close();
        writer.close();

    }
}
