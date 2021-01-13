package ru.job4j.tracker;

public class FindItemsAction implements UserAction{
    @Override
    public String name() {
        return "=== Find all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("В базе данных нет ни одной записи");
        } else {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
        return true;
    }
}
