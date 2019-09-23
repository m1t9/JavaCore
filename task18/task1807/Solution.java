package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());
        bufferedReader.close();

        int count = 0;
        while (inputStream.available() > 0) {
            int symbol = inputStream.read();
            if (symbol == 44)
                count++;
        }
        inputStream.close();

        System.out.println(count);
    }
}
