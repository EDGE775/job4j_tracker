package ru.job4j.tracker;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        ApplicationConfig.config(application);
        application.start();
    }
}
