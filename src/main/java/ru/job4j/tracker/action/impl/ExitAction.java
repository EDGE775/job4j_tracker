package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.AbstractUserAction;
import ru.job4j.tracker.action.Action;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ExitAction extends AbstractUserAction {
    public ExitAction(Output output) {
        super(Action.EXIT, output);
    }

    @Override
    public boolean execute(Input input, ItemRepositoryInterface itemRepository) {
        return false;
    }
}
