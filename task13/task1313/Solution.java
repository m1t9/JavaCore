package com.javarush.task.task13.task1313;

import java.awt.*;

/* 
Лисица — это такое животное
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public static abstract class Fox {

        public String getName() {
            return "Fox";
        }

        public interface Animal {
            Color getColor();
        }
    }
}