package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String currentObject;

    public Builder() {
    }

    public Builder(String name,
                   String surname,
                   String education,
                   String birthday,
                   String rank,
                   String currentObject) {
        super(name, surname, education, birthday, rank);
        this.currentObject = currentObject;
    }

    public Build toBuild() {
        Build build = new Build();
        return build;
    }
}
