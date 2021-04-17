package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.AbstractUserAction;
import ru.job4j.tracker.action.Action;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.data.entity.Item;

import java.util.List;

public class FindItemsByNameAction extends AbstractUserAction {
    public FindItemsByNameAction(Output output) {
        super(Action.FIND_BY_NAME, output);
    }

    @Override
    public boolean execute(Input input, ItemRepositoryInterface itemRepository) {
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
