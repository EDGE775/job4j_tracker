package ru.job4j.tracker.action;

public enum Action {
    CREATE("CREATE", 1),
    DELETE("DELETE", 2),
    FIND_BY_ID("FIND_BY_ID", 3),
    FIND_ALL("FIND_ALL", 4),
    FIND_BY_NAME("FIND_BY_NAME", 5),
    REPLACE("REPLACE", 6),
    EXIT("EXIT", 7);

    private String title;

    private Integer number;

    Action(String title, Integer number) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public Integer getNumber() {
        return number;
    }
}
