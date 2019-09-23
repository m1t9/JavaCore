package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileName));

        String text = "";
        while (bufferedReader.ready()) {
             text += bufferedReader.readLine();
        }
        bufferedReader.close();

        Document document = Jsoup.parse(text,  "", Parser.xmlParser());

        System.out.println(document.getElementsByTag(args[0]));


    }
}
