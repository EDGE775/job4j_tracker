package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"0", "Item name", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemAction(out),
                new ExitAction()
        };
        new StartUI(out).init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        assertThat(created.getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(new String[]{"0", "1", "New item name", "1"});
        UserAction[] actions = {
                new ReplaceItemAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        Input in = new StubInput(new String[]{"0", "1", "1"});
        UserAction[] actions = {
                new DeleteItemAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new FindItemByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
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
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("New Item 1"));
        Item item2 = tracker.add(new Item("New Item 2"));
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {
                new FindItemsAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find all Items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Find all Items ====" + System.lineSeparator()
                        + tracker.findAll()[0].toString() + System.lineSeparator()
                        + tracker.findAll()[1].toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find all Items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindItemsByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Finding Item 1"));
        Item item2 = tracker.add(new Item("Finding Item 2"));
        Input in = new StubInput(new String[]{"0", "Finding Item 1", "1"});
        UserAction[] actions = {
                new FindItemsByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find Items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Find Items by name ====" + System.lineSeparator()
                        + tracker.findAll()[0].toString() + System.lineSeparator()
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
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1", "0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit program%n"
                                + "Wrong input, you can select: 0 .. %d%n"
                                + "Menu.%n"
                                + "0. Exit program%n",
                        actions.length - 1)
                )
        );
    }
}