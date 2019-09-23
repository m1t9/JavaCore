package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 40;
    }

    @Override
    public String getDescription() {
        final String Sssss = Country.BELARUS;
        int N = getCountOfEggsPerMonth();
        return super.getDescription() + " Моя страна - " + Sssss + ". Я несу " + N + " яиц в месяц.";
    }

}
