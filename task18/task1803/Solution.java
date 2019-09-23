package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
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

        int max = 0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            if ((int) pair.getValue() > max) {
                max = (int) pair.getValue();
            }
        }

        Iterator iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator2.next();
            if ((int) pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }


    }
}
