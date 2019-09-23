package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        stream.close();
        outputStream.close();
        System.setOut(console);

        String[] result = outputStream.toString().split("\n");
        int count = 1;
        for (String value : result) {
            System.out.println(value);
            if (count == 2){
                System.out.println("JavaRush - курсы Java онлайн");
                count = 0;
            }
            count++;
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
