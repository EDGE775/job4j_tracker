package ru.job4j.tracker.data.repository;

import ru.job4j.tracker.data.entity.Item;

import java.util.List;

public interface ItemRepositoryInterface {
    Item add(Item item);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);

    boolean replace(int id, Item item);

    boolean delete(int id);

    void clearAll();
}
