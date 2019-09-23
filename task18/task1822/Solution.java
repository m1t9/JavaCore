package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();
        String data = new String(buffer);
        String[] dataArr = data.split("\n");

        for (String line : dataArr) {
            if (line.startsWith(args[0] + " ")) {
                System.out.println(line);
                break;
            }
        }


    }
}
