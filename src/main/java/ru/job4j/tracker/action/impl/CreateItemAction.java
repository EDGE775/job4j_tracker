package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.AbstractUserAction;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.action.Action;
import ru.job4j.tracker.data.entity.Item;

public class CreateItemAction extends AbstractUserAction {
    public CreateItemAction(Output output) {
        super(Action.CREATE, output);
    }

    @Override
    public boolean execute(Input input, ItemRepositoryInterface itemRepository) {
        out.println("=== Create a new Item ====");
        String name = input.printQuestionAndReadAnswer("Enter name: ");
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Incorrect name!");
        }
        Item item = new Item(name);
        itemRepository.add(item);
        return true;
    }
}
