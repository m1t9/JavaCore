package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;

        BufferedReader bufferdReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        String answ = "";
        while (bufferdReader.ready()) {
            String[] line = bufferdReader.readLine().split(" ");
            for (String value : line) {
                if (value.length() > 6)
                    answ += value + ",";
            }
        }
        bufferdReader.close();

        bufferedWriter.write(answ.substring(0, answ.length() - 1));
        bufferedWriter.close();
    }
}
