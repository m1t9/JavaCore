package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            map.merge(data, 1, Integer::sum);
        }
        inputStream.close();

        Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
        int min = (int) entry.getValue();

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            if ((int) pair.getValue() < min) {
                min = (int) pair.getValue();
            }
        }

        Iterator iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator2.next();
            if ((int) pair.getValue() == min) {
                System.out.print(pair.getKey() + " ");
            }
        }

    }
}
