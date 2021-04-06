package ru.job4j.tracker;

import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;

import java.util.List;

public class FindItemsAction implements UserAction {
    private final Output out;

    public FindItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all Items";
    }

    @Override
    public boolean execute(Input input, ItemRepository itemRepository) {
        out.println("=== Find all Items ====");
        List<Item> items = itemRepository.findAll();
        if (items.size() == 0) {
            out.println("В базе данных нет ни одной записи");
        } else {
            for (Item item : items) {
                out.println(item.toString());
            }
        }
        return true;
    }
}
