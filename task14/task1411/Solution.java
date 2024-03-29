package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        ArrayList<String> list = new ArrayList<String>(Arrays.asList( "user", "loser", "coder", "proger"));
        while (list.contains(key = reader.readLine())) {

            //создаем объект, пункт 2
            if (key.equals("user"))
                person = new Person.User();
            if (key.equals("loser"))
                person = new Person.Loser();
            if (key.equals("coder"))
                person = new Person.Coder();
            if (key.equals("proger"))
                person = new Person.Proger();

            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User)
            ((Person.User) person).live();
        if (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        if (person instanceof Person.Coder)
            ((Person.Coder) person).writeCode();
        if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();

    }
}
