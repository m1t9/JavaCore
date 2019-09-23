package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        SortedSet set = new TreeSet();

        while (inputStream.available() > 0) {
            set.add(inputStream.read());
        }
        inputStream.close();

        for (Object obj : set) {
            System.out.print(obj + " ");
        }

    }
}
