package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ItemRepositoryTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        Item item = new Item();
        item.setName("test1");
        itemRepository.add(item);
        Item result = itemRepository.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        Item bug = new Item();
        bug.setName("Bug");
        itemRepository.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        itemRepository.replace(id, bugWithDesc);
        assertThat(itemRepository.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        Item bug = new Item();
        bug.setName("Bug");
        itemRepository.add(bug);
        int id = bug.getId();
        itemRepository.delete(id);
        assertThat(itemRepository.findById(id), is(nullValue()));
    }
}