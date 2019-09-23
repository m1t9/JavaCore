package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int count = 0;
        while (fileInputStream.available() > 0) {
            int symbol = fileInputStream.read();
            if ((symbol >= 65 && symbol <= 90) || (symbol >=97 && symbol <= 122))
                count++;
        }
        fileInputStream.close();

        System.out.println(count);

    }
}
