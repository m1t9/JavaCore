package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;

        Map<String, Double> map = new TreeMap<String, Double>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");

            if (map.containsKey(line[0])) {
                map.put(line[0], map.get(line[0]) + Double.parseDouble(line[1]));
            } else {
                map.put(line[0], Double.parseDouble(line[1]));
            }
        }
        bufferedReader.close();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }

    }
}
