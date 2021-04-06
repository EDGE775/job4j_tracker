package ru.job4j.tracker;

import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;

import java.util.List;

public class FindItemsByNameAction implements UserAction {
    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Items by name";
    }

    @Override
    public boolean execute(Input input, ItemRepository itemRepository) {
        out.println("=== Find Items by name ====");
        String name = input.printQuestionAndReadAnswer("Enter the Item name to find: ");
        List<Item> items = itemRepository.findByName(name);
        if (items.size() == 0) {
            out.println("Заявки с таким именем не найдены");
        } else {
            for (Item item : items) {
                out.println(item.toString());
            }
        }
        return true;
    }
}
