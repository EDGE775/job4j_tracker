package ru.job4j.poly;

public interface Transport {
    void drive();

    void setPassengers(int count);

    int refuel(int count);
}
