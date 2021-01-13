package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the Item id to edit: ");
        String newName = input.askStr("Enter the new Item name: ");
        Item newItem = new Item(id, newName);
        if (tracker.replace(id, newItem)) {
            System.out.println("Операция выполнена успешно!");
        } else {
            System.out.println("Ошибка! Операция не выполнена!");
        }
        return true;
    }
}
