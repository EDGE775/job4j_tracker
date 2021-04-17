package ru.job4j.tracker.action;

import ru.job4j.tracker.output.Output;

public abstract class AbstractUserAction implements UserAction{

    private final Action action;

    protected final Output out;

    public AbstractUserAction(Action action, Output output) {
        this.action = action;
        this.out = output;
    }

    @Override
    public String name() {
        return action.name();
    }

    @Override
    public Integer getOrder() {
        return action.getNumber();
    }

    @Override
    public void printToScreen() {
        out.println(String.format("%s. %s", action.getNumber(), action.getTitle()));
    }
}
