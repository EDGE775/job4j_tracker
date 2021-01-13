package ru.job4j.tracker;

public class DeleteItemAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the Item id to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Операция выполнена успешно!");
        } else {
            System.out.println("Ошибка! Операция не выполнена!");
        }
        return true;
    }
}
