package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.AbstractUserAction;
import ru.job4j.tracker.action.Action;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class DeleteItemAction extends AbstractUserAction {

    public DeleteItemAction(Output output) {
        super(Action.DELETE, output);
    }

    @Override
    public boolean execute(Input input, ItemRepositoryInterface itemRepository) {
        out.println("=== Delete Item ====");
        int id = input.askInt("Enter the Item id to delete: ");
        if (itemRepository.delete(id)) {
            out.println("Операция выполнена успешно!");
        } else {
            out.println("Ошибка! Операция не выполнена!");
        }
        return true;
    }
}
