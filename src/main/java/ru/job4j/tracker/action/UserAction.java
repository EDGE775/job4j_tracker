package ru.job4j.tracker.action;

import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, ItemRepositoryInterface itemRepository);

    Integer getOrder();

    void printToScreen();
}
