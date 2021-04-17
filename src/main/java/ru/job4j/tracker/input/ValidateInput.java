package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String printQuestionAndReadAnswer(String question) {
        return in.printQuestionAndReadAnswer(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

}