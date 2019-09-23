package com.javarush.task.task18.task1812;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        AmigoOutputStream stream = new QuestionFileOutputStream();

        stream.close();
    }
}
