package ru.job4j.tracker;

import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Application {
    private Input input;
    private Output output;
    private ItemRepositoryInterface itemRepositoryInterface;
    private Collection<UserAction> actions;

    public void setInput(Input input) {
        this.input = input;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public void setItemRepositoryInterface(ItemRepositoryInterface itemRepositoryInterface) {
        this.itemRepositoryInterface = itemRepositoryInterface;
    }

    public void setActions(Collection<UserAction> actions) {
        this.actions = actions;
    }

    public void start() {
        boolean run = true;
        while (run) {
            showMenu();
            try {
                run = executeAction();
            } catch (RuntimeException e) {
//                System.out.println(e.getMessage());
                e.printStackTrace();
//                run = true;
            }
        }
    }

    private boolean executeAction() {
        boolean run;
        Integer selectNumber = input.askInt("Select: ");
        Optional<UserAction> option = actions.stream()
                .filter(action -> action.getOrder().equals(selectNumber))
                .findFirst();
        if (option.isPresent()) {
            run = option.get().execute(input, itemRepositoryInterface);
        } else {
            throw new IllegalArgumentException("Вы накосячили!");
        }
        return run;
    }

    private void showMenu() {
        output.println("Menu.");
        actions.forEach(UserAction::printToScreen);
    }
}
