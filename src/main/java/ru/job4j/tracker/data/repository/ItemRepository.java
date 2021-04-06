package ru.job4j.tracker.data.repository;

import ru.job4j.tracker.data.entity.Item;

import java.util.ArrayList;
import java.util.List;

public final class ItemRepository extends SingletonRepository implements ItemRepositoryInterface {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    private ItemRepository() {
    }

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> resultList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        int index = this.indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    @Override
    public boolean replace(int id, Item item) {
        int index = this.indexOf(id);
        boolean rsl = isIndexPresent(index);
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    private boolean isIndexPresent(int index) {
        return index != -1;
    }

    @Override
    public boolean delete(int id) {
        int index = this.indexOf(id);
        boolean rsl = isIndexPresent(index);
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    @Override
    public void clearAll() {
        items.clear();
        ids = 1;
    }
}