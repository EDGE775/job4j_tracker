package ru.job4j.inheritance;

public class Dentist extends Doctor{
    private int cabinet;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education, String birthday, String rank, int cabinet) {
        super(name, surname, education, birthday, rank);
        this.cabinet = cabinet;
    }

    public Tooth toPull() {
        Tooth tooth = new Tooth();
        return tooth;
    }
}
