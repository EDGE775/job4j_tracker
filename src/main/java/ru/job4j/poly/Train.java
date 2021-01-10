package ru.job4j.poly;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println("Поезд перемещается между станциями");
    }

    @Override
    public void start() {
        System.out.println("Поезд заводится с помощью кнопки");
    }
}
