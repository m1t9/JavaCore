package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();
//            System.out.println(javaRush.equals(loadedObject));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }


//        User user = new User();
//        user.setFirstName("Rubi");
//        user.setLastName("Rail");
//        user.setBirthDate(new Date(1508944516168L));
//        user.setMale(true);
//        user.setCountry(User.Country.OTHER);
//
//        User user1 = new User();
//        user1.setFirstName("Vasa1");
//        user1.setLastName("Peta1");
//        user1.setBirthDate(new Date(1508944516163L));
//        user1.setMale(true);
//        user1.setCountry(User.Country.RUSSIA);
//
//        User user3 = new User();
//        user3.setFirstName("Solo");
//        user3.setLastName("Han");
//        user3.setBirthDate(new Date(1508944516169L));
//        user3.setMale(true);
//        user3.setCountry(User.Country.UKRAINE);
//
//        JavaRush javaRush = new JavaRush();
//        javaRush.users.add(user);
//        javaRush.users.add(user1);
//        javaRush.users.add(user3);
//        javaRush.save(new FileOutputStream("d:/data.txt"));
//
//        JavaRush javaRush1 = new JavaRush();
//        javaRush1.load(new FileInputStream("d:/data.txt"));
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (users.size() != 0) {
                PrintWriter printWriter = new PrintWriter(outputStream);
                for (User user : users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate().getTime());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }
                printWriter.flush();
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()) {
                User user = new User();
                user.setFirstName(bufferedReader.readLine());
                user.setLastName(bufferedReader.readLine());

                Date date = new Date();
                date.setTime(Long.parseLong(bufferedReader.readLine()));
                user.setBirthDate(date);

                String male = bufferedReader.readLine();
                if (male.equals("true")) {
                    user.setMale(true);
                } else {
                    user.setMale(false);
                }

                String countyString = bufferedReader.readLine();
                user.setCountry(User.Country.valueOf(countyString));

                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
