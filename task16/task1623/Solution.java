package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(String.valueOf(++Solution.createdThreadCount));
            this.start();
        }

        @Override
        public void run() {
            if (Solution.createdThreadCount < count) {
                GenerateThread generateThread = new GenerateThread();
                System.out.println(generateThread.toString());
            }
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }
    }
}
