package ru.job4j.tracker;

import ru.job4j.tracker.data.repository.ItemRepository;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, ItemRepository itemRepository) {
        return false;
    }
}
