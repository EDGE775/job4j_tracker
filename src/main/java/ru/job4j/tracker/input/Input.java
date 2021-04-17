package ru.job4j.tracker.input;

public interface Input {
    String printQuestionAndReadAnswer(String question);

    int askInt(String question);
}
