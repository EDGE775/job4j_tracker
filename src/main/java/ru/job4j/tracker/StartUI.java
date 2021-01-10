package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Find all Items ====");
                Item[] items = tracker.findAll();
                if (items.length == 0) {
                    System.out.println("В базе данных нет ни одной записи");
                } else {
                    for (Item item : items) {
                        System.out.println(item.toString());
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                int id = input.askInt("Enter the Item id to edit: ");
                String newName = input.askStr("Enter the new Item name: ");
                Item newItem = new Item(id, newName);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Операция выполнена успешно!");
                } else {
                    System.out.println("Ошибка! Операция не выполнена!");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                int id = input.askInt("Enter the Item id to delete: ");
                if (tracker.delete(id)) {
                    System.out.println("Операция выполнена успешно!");
                } else {
                    System.out.println("Ошибка! Операция не выполнена!");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by Id ====");
                int id = input.askInt("Enter the Item id to find: ");
                Item item = tracker.findById(id);
                String rsl = item == null ? "Заявка с таким id не найдена" : item.toString();
                System.out.println(rsl);
            } else if (select == 5) {
                System.out.println("=== Find Items by name ====");
                String name = input.askStr("Enter the Item name to find: ");
                Item[] items = tracker.findByName(name);
                if (items.length == 0) {
                    System.out.println("Заявки с таким именем не найдены");
                } else {
                    for (Item item : items) {
                        System.out.println(item.toString());
                    }
                }
            } else if (select == 6) {
                run = false;
                System.out.println("Выход из программы");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}