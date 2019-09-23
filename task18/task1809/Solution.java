package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputFileName = bufferedReader.readLine();
        String outputFileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream inputStream = new FileInputStream(inputFileName);

        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);

        }
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(outputFileName);
        for (int i = buffer.length - 1; i >= 0; i--) {
            outputStream.write(buffer[i]);
        }
        outputStream.close();

    }
}
