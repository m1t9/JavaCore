package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        byte[] buffer = new byte[fileInputStream.available()];

        fileInputStream.read(buffer);
        fileInputStream.close();

        for (byte symbol : buffer) {
            if (args[0].equals("-e")) {
                fileOutputStream.write(symbol + 1);
            } else if (args[0].equals("-d")) {
                fileOutputStream.write(symbol - 1);
            }
        }
        fileOutputStream.close();

    }

}
