package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        if (this.quality > o.quality) {
            return this.quality - o.quality;
        } else if (this.quality < o.quality) {
            return this.quality - o.quality;
        }
        if (this.distance < o.distance) {
            return (int) (o.distance - this.distance);
        }
        return (int) (o.distance - this.distance);
    }

    public static void main(String[] args) {
//        Beach b1 = new Beach("b1", 200, 5);
//        Beach b2 = new Beach("b2", 100, 5);
//
//        System.out.println(b1.compareTo(b2));
    }
}
