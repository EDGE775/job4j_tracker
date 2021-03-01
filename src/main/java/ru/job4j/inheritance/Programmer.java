package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String currentProject;

    public Programmer() {
    }

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      String rank,
                      String currentProject) {
        super(name, surname, education, birthday, rank);
        this.currentProject = currentProject;
    }

    public Program toProg() {
        Program program = new Program();
        return program;
    }
}
