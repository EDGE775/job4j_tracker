package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"0", "Item name", "1"};
        Input input = new StubInput(answers);
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        List<UserAction> actions = Arrays.asList(
                new CreateItemAction(out),
                new ExitAction());
        new StartUI(out).init(input, itemRepository, actions);
        Item created = itemRepository.findAll().get(0);
        assertThat(created.getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        Item item = itemRepository.add(new Item("Replaced item"));
        Input in = new StubInput(new String[]{"0",
                String.valueOf(item.getId()),
                "New item name",
                "1"});
        List<UserAction> actions = Arrays.asList(
                new ReplaceItemAction(out),
                new ExitAction());
        new StartUI(out).init(in, itemRepository, actions);
        assertThat(itemRepository.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        Item item = itemRepository.add(new Item("Deleted Item"));
        Input in = new StubInput(new String[]{"0", "1", "1"});
        List<UserAction> actions = Arrays.asList(
                new DeleteItemAction(out),
                new ExitAction());
        new StartUI(out).init(in, itemRepository, actions);
        assertThat(itemRepository.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        Item item = itemRepository.add(new Item("New Item"));
        Input in = new StubInput(new String[]{"0", "1", "1"});
        List<UserAction> actions = Arrays.asList(
                new FindItemByIdAction(out),
                new ExitAction());
        new StartUI(out).init(in, itemRepository, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find Item by Id" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Find Item by Id ====" + System.lineSeparator()
                        + item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find Item by Id" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindItems() {
        Output out = new StubOutput();
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        itemRepository.add(new Item("New Item 1"));
        itemRepository.add(new Item("New Item 2"));
        Input in = new StubInput(new String[]{"0", "1"});
        List<UserAction> actions = Arrays.asList(
                new FindItemsAction(out),
                new ExitAction());
        new StartUI(out).init(in, itemRepository, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find all Items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Find all Items ====" + System.lineSeparator()
                        + itemRepository.findAll().get(0).toString() + System.lineSeparator()
                        + itemRepository.findAll().get(1).toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find all Items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindItemsByName() {
        Output out = new StubOutput();
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        itemRepository.add(new Item("Finding Item 1"));
        itemRepository.add(new Item("Finding Item 2"));
        Input in = new StubInput(new String[]{"0", "Finding Item 1", "1"});
        List<UserAction> actions = Arrays.asList(
                new FindItemsByNameAction(out),
                new ExitAction());
        new StartUI(out).init(in, itemRepository, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find Items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Find Items by name ====" + System.lineSeparator()
                        + itemRepository.findAll().get(0).toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find Items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        List<UserAction> actions = Arrays.asList(
                new ExitAction());
        new StartUI(out).init(in, itemRepository, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1", "0"});
        ItemRepository itemRepository = ItemRepository.getInstance();
        itemRepository.clearAll();
        List<UserAction> actions = Arrays.asList(
                new ExitAction());
        new StartUI(out).init(in, itemRepository, actions);
        //String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit program%n"
                                + "Wrong input, you can select: 0 .. %d%n"
                                + "Menu.%n"
                                + "0. Exit program%n",
                        actions.size() - 1)
                )
        );
    }
}