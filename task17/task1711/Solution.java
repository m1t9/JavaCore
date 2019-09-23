package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length != 0) {
            switch (args[0]){
                case "-c":
                    synchronized (allPeople) {
                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        int indexOut = allPeople.size();
                        for (int i = 1; i < args.length; i += 3) {
                            Date bdC = formatter1.parse((args[i + 2]));
                            if (args[i + 1].equals("м")) {
                                allPeople.add(Person.createMale(args[i], bdC));
                            } else {
                                allPeople.add(Person.createFemale(args[i], bdC));
                            }
                            System.out.println(indexOut);
                            indexOut++;
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                        for (int i = 1; i < args.length; i += 4) {
                            try {
                                Date bdU = formatter2.parse((args[i + 3]));
                                int index = Integer.parseInt(args[i]);
                                allPeople.get(index).setName(args[i + 1]);
                                allPeople.get(index).setBirthDate(bdU);
                                if (args[i + 2].equals("м")) {
                                    allPeople.get(index).setSex(Sex.MALE);
                                } else {
                                    allPeople.get(index).setSex(Sex.FEMALE);
                                }
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            try {
                                int index = Integer.parseInt(args[i]);
                                allPeople.get(index).setName(null);
                                allPeople.get(index).setSex(null);
                                allPeople.get(index).setBirthDate(null);
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            try {
                                int index = Integer.parseInt(args[i]);
                                String name = allPeople.get(index).getName();
                                String sex = "";
                                if (allPeople.get(index).getSex().equals(Sex.MALE)) {
                                    sex = "м";
                                } else {
                                    sex = "ж";
                                }
                                SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                                String data = formatter3.format(allPeople.get(index).getBirthDate());

                                System.out.println(name + " " + sex + " " + data);
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                default:
                    break;
            }


        }

    }
}
