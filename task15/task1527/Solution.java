package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] urlParamValue = url.substring(url.indexOf("?") + 1).split("&");

        String paramOut = "";
        for (String param : urlParamValue) {
            paramOut += param.split("=")[0] + " ";
        }
        paramOut = paramOut.trim();
        System.out.println(paramOut);

        for (String param : urlParamValue) {
            if (param.split("=")[0].equals("obj")) {
                try {
                    alert(Double.parseDouble(param.split("=")[1]));
                } catch (Exception e) {
                    alert(param.split("=")[1]);
                }
            }
        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
