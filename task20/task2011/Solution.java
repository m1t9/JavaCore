package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
            out.flush();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String) in.readObject();
            this.year = (int) in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Apartment apartment = new Apartment("SPb" , 1703);
//
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:/data.txt"));
//
//        apartment.writeExternal(outputStream);
//
//        Apartment apartment1 = new Apartment();
//
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d:/data.txt"));
//        apartment1.readExternal(inputStream);
//
//        System.out.println(apartment1.address);

    }
}
