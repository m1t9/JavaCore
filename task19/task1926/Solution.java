package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()) {
            String[] symbols = bufferedReader.readLine().split("");
            for (int i = symbols.length - 1; i >= 0; i--) {
                System.out.print(symbols[i]);
            }
            System.out.println();
        }

        bufferedReader.close();

    }
}
