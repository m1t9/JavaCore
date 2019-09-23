package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream1 = new FileOutputStream(fileName2);
        FileOutputStream outputStream2 = new FileOutputStream(fileName3);
        bufferedReader.close();

        byte[] buffer1 = new byte[inputStream.available() - (inputStream.available() / 2)];
        byte[] buffer2 = new byte[inputStream.available() / 2];

        int count = inputStream.read(buffer1);
        outputStream1.write(buffer1, 0 , count);
        outputStream1.close();
        count = inputStream.read(buffer2);
        int start = inputStream.available() - (inputStream.available() / 2);
        outputStream2.write(buffer2, start, count);
        outputStream2.close();
        inputStream.close();

    }
}
