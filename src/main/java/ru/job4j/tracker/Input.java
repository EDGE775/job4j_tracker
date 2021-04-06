package ru.job4j.tracker;

public interface Input {
    String printQuestionAndReadAnswer(String question);

    int askInt(String question);
}
