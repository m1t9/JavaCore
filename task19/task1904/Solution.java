package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String line = fileScanner.nextLine();
            String[] data = line.split(" ");

            int year = Integer.parseInt(data[5]);
            int month = Integer.parseInt(data[4]) - 1;
            int day = Integer.parseInt(data[3]);
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            Date bDay = calendar.getTime();

            return new Person(data[1], data[2], data[0], bDay);

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
