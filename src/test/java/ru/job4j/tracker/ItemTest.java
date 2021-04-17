package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.comparator.ItemNameAdvanceSorter;
import ru.job4j.tracker.comparator.ItemNameDescendSorter;
import ru.job4j.tracker.data.entity.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenAdvanceSortByName() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Борис Кристофорович");
        Item item2 = new Item("Арнольд Борисович");
        Item item3 = new Item("Янковский Ян");
        Item item4 = new Item("Малой Альберт");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.sort(new ItemNameAdvanceSorter());
        List<String> result = new ArrayList<>();
        for (Item item : items) {
            result.add(item.getName());
        }
        List<String> expect = Arrays.asList("Арнольд Борисович",
                "Борис Кристофорович",
                "Малой Альберт",
                "Янковский Ян");
        assertThat(result, is(expect));
    }

    @Test
    public void whenDescendSortByName() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Борис Кристофорович");
        Item item2 = new Item("Арнольд Борисович");
        Item item3 = new Item("Янковский Ян");
        Item item4 = new Item("Малой Альберт");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.sort(new ItemNameDescendSorter());
        List<String> result = new ArrayList<>();
        for (Item item : items) {
            result.add(item.getName());
        }
        List<String> expect = Arrays.asList("Янковский Ян",
                "Малой Альберт",
                "Борис Кристофорович",
                "Арнольд Борисович");
        assertThat(result, is(expect));
    }
}