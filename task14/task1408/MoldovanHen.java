package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 45;
    }

    @Override
    public String getDescription() {
        final String Sssss = Country.MOLDOVA;
        int N = getCountOfEggsPerMonth();
        return super.getDescription() + " Моя страна - " + Sssss + ". Я несу " + N + " яиц в месяц.";
    }

}
