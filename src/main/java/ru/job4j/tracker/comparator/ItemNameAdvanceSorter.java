package ru.job4j.tracker.comparator;

import ru.job4j.tracker.data.entity.Item;

import java.util.Comparator;

public class ItemNameAdvanceSorter implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
