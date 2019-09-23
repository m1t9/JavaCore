package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        return fact(BigInteger.valueOf(n)).toString();
    }

    public static BigInteger fact(BigInteger i) {
        if (i.compareTo(BigInteger.valueOf(0)) == 0) {
            return BigInteger.valueOf(1);
        } else if (i.compareTo(BigInteger.valueOf(0)) == -1) {
            return BigInteger.valueOf(0);
        } else {
            return fact(i.subtract(BigInteger.valueOf(1))).multiply(i);
        }
    }
}
