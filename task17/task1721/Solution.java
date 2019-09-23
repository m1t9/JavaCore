package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            Runnable read1 = new Runnable() {
                @Override
                public void run() {
                    try {
                        new Solution().readFile(fileName1, allLines);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable read2 = new Runnable() {
                @Override
                public void run() {
                    try {
                        new Solution().readFile(fileName2, forRemoveLines);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread readThread1 = new Thread(read1);
            Thread readThread2 = new Thread(read2);

            readThread1.start();
            readThread2.start();
            readThread1.join();
            readThread2.join();

            new Solution().joinData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

    private void readFile(String name, List<String> list) throws IOException {
//        allLines = Files.readAllLines(Paths.get(bufferedReader.readLine()));

        File file = new File(name);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }

        bufferedReader.close();
    }

}
