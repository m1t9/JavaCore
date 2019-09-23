package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStram = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(consoleStram);

        String[] line = outputStream.toString().replaceAll("\\r\n", "").split(" ");
        String result = "";
        if (line[1].equals("+")) {
            result = outputStream.toString().trim() + " " + String.valueOf(Integer.parseInt(line[0]) + Integer.parseInt(line[2]));
        }
        if (line[1].equals("-")) {
            result = outputStream.toString().trim() + " " + (Integer.parseInt(line[0]) - Integer.parseInt(line[2]));
        }
        if (line[1].equals("*")) {
            result = outputStream.toString().trim() + " " + (Integer.parseInt(line[0]) * Integer.parseInt(line[2]));
        }

        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

