package ru.job4j.oop;

public class Fix {
    private String desc;

    public Fix(String text) {
        desc = text;
    }

    public static void main(String[] args) {
        Fix item = new Fix("Fix text");
    }
}
