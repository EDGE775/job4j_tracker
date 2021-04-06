package ru.job4j.tracker;

import ru.job4j.tracker.data.repository.ItemRepository;

public interface UserAction {
    String name();

    boolean execute(Input input, ItemRepository itemRepository);
}
