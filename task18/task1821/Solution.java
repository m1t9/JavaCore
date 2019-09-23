package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<Character, Integer> map = new TreeMap<Character, Integer>();

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0) {
            int symbol = fileInputStream.read();
            if (!map.containsKey((char) symbol)) {
                map.put((char) symbol, 1);
            } else {
                map.put((char) symbol, map.get((char) symbol) + 1);
            }
        }
        fileInputStream.close();

        for (Character key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
