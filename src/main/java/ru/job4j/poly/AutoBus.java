package ru.job4j.poly;

public class AutoBus implements Vehicle{
    @Override
    public void move() {
        System.out.println("Автобус курсирует между остановками");
    }

    @Override
    public void start() {
        System.out.println("Автобус заводится ключом");
    }
}
