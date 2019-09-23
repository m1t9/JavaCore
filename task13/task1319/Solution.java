package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String FILE_NAME = reader.readLine();

        ArrayList<String> inputStrings = new ArrayList<String>();

        while (true) {
            String line = reader.readLine();
            inputStrings.add(line);
            if (line.equals("exit"))
                break;
        }

        reader.close();
//
//        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
//        BufferedOutputStream bufferedStream = new BufferedOutputStream(outputStream);
//
//        for (int i = 0; i < inputStrings.size(); i++) {
//            String text = inputStrings.get(i);
//            System.out.println(text);
//            byte[] buffer = text.getBytes();
//
//            bufferedStream.write(buffer, 0, buffer.length);

//        }

        try {

            FileWriter fileWrite = new FileWriter(FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);

            for (int i = 0; i < inputStrings.size(); i++) {
                bufferedWriter.write(inputStrings.get(i) + "\n");
            }

            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
