package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    static Properties property = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        load(fileInputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.putAll(properties);
        property.store(outputStream, null);

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.load(inputStream);

        for (String propertyName : property.stringPropertyNames()) {
            properties.put(propertyName, property.getProperty(propertyName));
        }

    }

    public static void main(String[] args) {


    }
}
