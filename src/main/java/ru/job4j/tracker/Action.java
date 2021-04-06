package ru.job4j.tracker;

public enum Action {
    CREATE_ITEM("Create");

    private String title;

    Action(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
