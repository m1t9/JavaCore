package com.javarush.task.test;

import java.io.IOException;
import java.sql.*;

public class Solution1 {
    public static void main(String[] args) throws IOException, InterruptedException {

////        System.out.println(HighAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
//        String string = "abc";
//        String string2 = "abc";
//        System.out.println(string);
//        System.out.println(string.hashCode());
//        System.out.println(string2.hashCode());
//        if (string.hashCode() == string2.hashCode())
//            System.out.println(true);
//        System.out.println(string.getClass());

        String line = "";
        for (int i = 0; i < 10; i++) {
            System.out.println("3");
            System.out.print("\r");
            System.out.print("\r" + i);
//            System.out.print(i);
            Thread.sleep(300);
        }

    }

//    public static String HighAndLow(String numbers) {
//        // Code here or
//        String num[] = numbers.split(" ");
//        int min = Integer.parseInt(num[0]), max = Integer.parseInt(num[0]);
//        for (String value : num) {
//            int valueInt = Integer.parseInt(value);
//            if (valueInt > max) max = valueInt;
//            if (valueInt < min) min = valueInt;
//        }
//        return String.valueOf(max) + " " + String.valueOf(min);
//    }
}