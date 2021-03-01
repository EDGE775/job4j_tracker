package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int surgeryNumber;

    public Surgeon() {
    }

    public Surgeon(String name,
                   String surname,
                   String education,
                   String birthday,
                   String rank,
                   int surgeryNumber) {
        super(name, surname, education, birthday, rank);
        this.surgeryNumber = surgeryNumber;
    }

    public Organ toCut() {
        Organ organ = new Organ();
        return organ;
    }
}
