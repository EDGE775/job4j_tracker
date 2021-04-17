package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.AbstractUserAction;
import ru.job4j.tracker.action.Action;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.data.entity.Item;

import java.util.List;

public class FindItemsAction extends AbstractUserAction {
    public FindItemsAction(Output output) {
        super(Action.FIND_ALL, output);
    }

    @Override
    public boolean execute(Input input, ItemRepositoryInterface itemRepository) {
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
