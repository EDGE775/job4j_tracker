package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;
    private int fuel = 100;

    @Override
    public void drive() {
        System.out.println("Автобус едет!");
        fuel--;
    }

    @Override
    public void setPassengers(int count) {
        this.passengers = count;
    }

    @Override
    public int refuel(int count) {
        fuel += count;
        return fuel;
    }
}
