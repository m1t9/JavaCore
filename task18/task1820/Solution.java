package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String firstFileName = bufferedReader.readLine();
        String secondFileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(firstFileName));

        int i;
        String s = "";

        while ((i = bufferedInputStream.read()) != -1) {
            s += (char) i;
        }
        bufferedInputStream.close();

        String[] nums = s.split(" ");

        String roundStringNums = "";
        for (String num : nums) {
            int roundNum = Math.round(Float.parseFloat(num));
            roundStringNums += roundNum;
            if (!num.equals(nums[nums.length - 1])) roundStringNums += " ";
        }

        FileOutputStream fileOutputStream = new FileOutputStream(secondFileName);
        fileOutputStream.write(roundStringNums.getBytes());
        fileOutputStream.close();

    }
}
