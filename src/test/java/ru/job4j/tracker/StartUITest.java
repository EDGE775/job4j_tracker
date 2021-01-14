package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"0", "Item name", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemAction(),
                new ExitAction()
        };
        StartUI.init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        assertThat(created.getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(new String[] {"0", "1", "New item name", "1"});
        UserAction[] actions = {
                new ReplaceItemAction(),
                new ExitAction()
        };
        StartUI.init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        Input in = new StubInput(new String[] {"0", "1", "1"});
        UserAction[] actions = {
                new DeleteItemAction(),
                new ExitAction()
        };
        StartUI.init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}