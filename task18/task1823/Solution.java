package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        while (!(fileName = bufferedReader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }
        bufferedReader.close();

    }

    public static class ReadThread extends Thread {

        private final String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            try {

                FileInputStream fileInputStream = new FileInputStream(fileName);
                int max = 0;
                while (fileInputStream.available() > 0) {
                    int symbol = fileInputStream.read();
                    if (!map.containsKey((char) symbol)) {
                        map.put((char) symbol, 1);
                    } else {
                        map.put((char) symbol, map.get((char) symbol) + 1);
                    }
                    if (map.get((char) symbol) > max) {
                        max = map.get((char) symbol);
                    }
                }
                fileInputStream.close();
                for (Character symbol : map.keySet()) {
                    if (map.get(symbol) == max) {
                        synchronized (resultMap) {
                            resultMap.put(fileName, (int) symbol);
                        }
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
