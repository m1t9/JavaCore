package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        String answ = "";
        while (bufferedReader.ready()) {

            String[] line = bufferedReader.readLine().split(" ");
            for (String value : line) {
                if (!value.replaceAll("\\d", "").equals(value)) {
                    answ += value + " ";
                }
            }

        }
        answ = answ.trim();
        bufferedWriter.write(answ);

        bufferedReader.close();
        bufferedWriter.close();

    }
}
