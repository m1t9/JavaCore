package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> map = new TreeMap<String, Double>();
        Set<String> set = new TreeSet<String>();

        double max = 0.0;
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");

            if (map.containsKey(line[0])) {
                map.put(line[0], map.get(line[0]) + Double.parseDouble(line[1]));
            } else {
                map.put(line[0], Double.parseDouble(line[1]));
            }
            if (map.get(line[0]) > max)
                max = map.get(line[0]);
        }
        bufferedReader.close();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == max)
                set.add(entry.getKey());
        }

        for (String name : set) {
            System.out.println(name);
        }

    }
}
