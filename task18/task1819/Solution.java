package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = bufferedReader.readLine();
        String secondFileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(firstFileName);

        byte[] firstBuffer = new byte[fileInputStream.available()];
        fileInputStream.read(firstBuffer);
        fileInputStream.close();
        fileInputStream = new FileInputStream(secondFileName);
        byte[] secondBuffer = new byte[fileInputStream.available()];
        fileInputStream.read(secondBuffer);
        byte[] buffer = new byte[firstBuffer.length + secondBuffer.length];
        fileInputStream.close();


        FileOutputStream fileOutputStream = new FileOutputStream(firstFileName);
        fileOutputStream.write(secondBuffer);
        fileOutputStream.write(firstBuffer);

        fileOutputStream.close();

    }
}
