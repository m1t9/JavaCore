package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        if (args.length != 0){
            switch (args[0]) {
                case "-c":
                    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                    Date bdC = formatter1.parse(args[3]);
                    if (args[2].equals("м"))
                        allPeople.add(Person.createMale(args[1], bdC ));
                    if (args[2].equals("ж"))
                        allPeople.add(Person.createFemale(args[1], bdC ));
                    System.out.println(allPeople.size() - 1);
                    break;
                case "-u":
                    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                    Date bdU = formatter2.parse(args[4]);
                    int index = Integer.parseInt(args[1]);
                    allPeople.get(index).setName(args[2]);
                    if (args[3].equals("м"))
                        allPeople.get(index).setSex(Sex.MALE);
                    if (args[3].equals("ж"))
                        allPeople.get(index).setSex(Sex.FEMALE);
                    allPeople.get(index).setBirthDate(bdU);
                    break;
                case "-d":
                    int indexD = Integer.parseInt(args[1]);
                    allPeople.get(indexD).setName(null);
                    allPeople.get(indexD).setSex(null);
                    allPeople.get(indexD).setBirthDate(null);
                    break;
                case "-i":
                    int indexI = Integer.parseInt(args[1]);
                    String name = allPeople.get(indexI).getName();
                    String sex = "";
                    if (allPeople.get(indexI).getSex().equals(Sex.MALE)) {
                        sex = "м";
                    } else {
                        sex = "ж";
                    }
                    SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    String data = formatter3.format(allPeople.get(indexI).getBirthDate());

                    System.out.println(name + " " + sex + " " + data);
                    break;
                default:
                    break;
            }
        }

    }
}
