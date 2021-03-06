package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Items by name ====");
        String name = input.askStr("Enter the Item name to find: ");
        List<Item> items = tracker.findByName(name);
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
