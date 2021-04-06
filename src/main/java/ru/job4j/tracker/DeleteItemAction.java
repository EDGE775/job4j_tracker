package ru.job4j.tracker;

import ru.job4j.tracker.data.repository.ItemRepository;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, ItemRepository itemRepository) {
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
