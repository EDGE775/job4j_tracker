package ru.job4j.poly;

public class Traffic {
    public static void main(String[] args) {
        Vehicle bus1 = new AutoBus();
        Vehicle bus2 = new AutoBus();
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle[] traffic = {bus1, bus2, plane1, plane2, train1, train2};
        for (Vehicle v : traffic) {
            v.start();
            v.move();
        }
    }
}
