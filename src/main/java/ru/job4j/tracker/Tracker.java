package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithoutNull = this.findAll();
        Item[] rsl = new Item[itemsWithoutNull.length];
        int index = 0;
        for (int i = 0; i < itemsWithoutNull.length; i++) {
            Item item = itemsWithoutNull[i];
            if (item.getName().equals(key)) {
                rsl[index++] = item;
            }
        }
        rsl = Arrays.copyOf(rsl, index);
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = this.indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = this.indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = this.indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            int start = index + 1;
            int length = items.length - index - 1;
            items[index] = null;
            System.arraycopy(items, start, items, index, length);
            items[items.length - 1] = null;
            size--;
        }
        return rsl;
    }
}