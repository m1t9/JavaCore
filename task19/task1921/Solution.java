package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        if (args.length == 0)
            return;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");
            int day = Integer.parseInt(line[line.length - 3]);
            int mounth = Integer.parseInt(line[line.length - 2]);
            int year = Integer.parseInt(line[line.length - 1]);

            String name = "";

            for (int i = 0; i < line.length - 3; i++) {
                name += line[i] + " ";
            }
            name = name.trim();

            Person person = new Person(name, new Date(year - 1900, mounth - 1, day));
            PEOPLE.add(person);

        }
        bufferedReader.close();

    }
}
