package ru.job4j.tracker;

public class StartUI {

    public static void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            StartUI.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private static void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemAction(),
                new DeleteItemAction(),
                new FindItemByIdAction(),
                new FindItemsAction(),
                new FindItemsByNameAction(),
                new ReplaceItemAction(),
                new ExitAction()
        };
        StartUI.init(input, tracker, actions);
    }
}