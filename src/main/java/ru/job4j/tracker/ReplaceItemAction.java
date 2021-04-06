package ru.job4j.tracker;

import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;

public class ReplaceItemAction implements UserAction {
    private final Output out;

    public ReplaceItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, ItemRepository itemRepository) {
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
