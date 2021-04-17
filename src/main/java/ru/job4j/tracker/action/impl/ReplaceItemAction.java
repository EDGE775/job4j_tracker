package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.AbstractUserAction;
import ru.job4j.tracker.action.Action;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.data.entity.Item;

public class ReplaceItemAction extends AbstractUserAction {
    public ReplaceItemAction(Output output) {
        super(Action.REPLACE, output);
    }

    @Override
    public boolean execute(Input input, ItemRepositoryInterface itemRepository) {
        out.println("=== Edit Item ====");
        int id = input.askInt("Enter the Item id to edit: ");
        String newName = input.printQuestionAndReadAnswer("Enter the new Item name: ");
        Item newItem = new Item(id, newName);
        if (itemRepository.replace(id, newItem)) {
            out.println("Операция выполнена успешно!");
        } else {
            out.println("Ошибка! Операция не выполнена!");
        }
        return true;
    }
}
