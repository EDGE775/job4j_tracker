package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find Items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter the Item name to find: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Заявки с таким именем не найдены");
        } else {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
        return true;
    }
}
