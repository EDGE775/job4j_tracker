package ru.job4j.tracker;

import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;

public class CreateItemAction implements UserAction {
    private final Output out;

    public CreateItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return Action.CREATE_ITEM.getTitle();
    }

    @Override
    public boolean execute(Input input, ItemRepository itemRepository) {
        out.println("=== Create a new Item ====");
        String name = input.printQuestionAndReadAnswer("Enter name: ");
        Item item = new Item(name);
        itemRepository.add(item);
        return true;
    }
}
