package ru.job4j.poly;

public class Plane implements Vehicle{
    @Override
    public void move() {
        System.out.println("Самолёт летит в пункт назначения");
    }

    @Override
    public void start() {
        System.out.println("Чтобы завести самолёт нужно 2 пилота");
    }
}
