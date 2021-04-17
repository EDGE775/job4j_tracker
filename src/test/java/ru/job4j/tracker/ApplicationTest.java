package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.action.impl.*;
import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"1", "Item name", "7"};
        Input input = new StubInput(answers);
        ItemRepositoryInterface itemRepository = new ItemRepository();
        List<UserAction> actions = Arrays.asList(
                new CreateItemAction(out),
                new ExitAction(out));
        Application application = new Application();
        application.setItemRepositoryInterface(itemRepository);
        application.setOutput(out);
        application.setInput(input);
        application.setActions(actions);
        application.start();
        Item created = itemRepository.findAll().get(0);
        assertThat(created.getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        ItemRepositoryInterface itemRepository = new ItemRepository();
        Item item = itemRepository.add(new Item("Replaced item"));
        Input in = new StubInput(new String[]{"6",
                String.valueOf(item.getId()),
                "New item name",
                "7"});
        List<UserAction> actions = Arrays.asList(
                new ReplaceItemAction(out),
                new ExitAction(out));
        Application application = new Application();
        application.setItemRepositoryInterface(itemRepository);
        application.setOutput(out);
        application.setInput(in);
        application.setActions(actions);
        application.start();
        assertThat(itemRepository.findById(item.getId()).getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        ItemRepositoryInterface itemRepository = new ItemRepository();
        itemRepository.clearAll();
        Item item = itemRepository.add(new Item("Deleted Item"));
        Input in = new StubInput(new String[]{"2", "1", "7"});
        List<UserAction> actions = Arrays.asList(
                new DeleteItemAction(out),
                new ExitAction(out));
        Application application = new Application();
        application.setItemRepositoryInterface(itemRepository);
        application.setOutput(out);
        application.setInput(in);
        application.setActions(actions);
        application.start();
        assertThat(itemRepository.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        ItemRepositoryInterface itemRepository = new ItemRepository();
        itemRepository.clearAll();
        Item item = itemRepository.add(new Item("New Item"));
        Input in = new StubInput(new String[]{"3", "1", "7"});
        List<UserAction> actions = Arrays.asList(
                new FindItemByIdAction(out),
                new ExitAction(out));
        Application application = new Application();
        application.setItemRepositoryInterface(itemRepository);
        application.setOutput(out);
        application.setInput(in);
        application.setActions(actions);
        application.start();
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "3. FIND_BY_ID" + System.lineSeparator()
                        + "7. EXIT" + System.lineSeparator()
                        + "=== Find Item by Id ====" + System.lineSeparator()
                        + item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "3. FIND_BY_ID" + System.lineSeparator()
                        + "7. EXIT" + System.lineSeparator()));
    }

    @Test
    public void whenFindItems() {
        Output out = new StubOutput();
        ItemRepositoryInterface itemRepository = new ItemRepository();
        itemRepository.clearAll();
        itemRepository.add(new Item("New Item 1"));
        itemRepository.add(new Item("New Item 2"));
        Input in = new StubInput(new String[]{"4", "7"});
        List<UserAction> actions = Arrays.asList(
                new FindItemsAction(out),
                new ExitAction(out));
        Application application = new Application();
        application.setItemRepositoryInterface(itemRepository);
        application.setOutput(out);
        application.setInput(in);
        application.setActions(actions);
        application.start();
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "4. FIND_ALL" + System.lineSeparator()
                        + "7. EXIT" + System.lineSeparator()
                        + "=== Find all Items ====" + System.lineSeparator()
                        + itemRepository.findAll().get(0).toString() + System.lineSeparator()
                        + itemRepository.findAll().get(1).toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "4. FIND_ALL" + System.lineSeparator()
                        + "7. EXIT" + System.lineSeparator()));
    }

    @Test
    public void whenFindItemsByName() {
        Output out = new StubOutput();
        ItemRepositoryInterface itemRepository = new ItemRepository();
        itemRepository.clearAll();
        itemRepository.add(new Item("Finding Item 1"));
        itemRepository.add(new Item("Finding Item 2"));
        Input in = new StubInput(new String[]{"5", "Finding Item 1", "7"});
        List<UserAction> actions = Arrays.asList(
                new FindItemsByNameAction(out),
                new ExitAction(out));
        Application application = new Application();
        application.setItemRepositoryInterface(itemRepository);
        application.setOutput(out);
        application.setInput(in);
        application.setActions(actions);
        application.start();
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "5. FIND_BY_NAME" + System.lineSeparator()
                        + "7. EXIT" + System.lineSeparator()
                        + "=== Find Items by name ====" + System.lineSeparator()
                        + itemRepository.findAll().get(0).toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "5. FIND_BY_NAME" + System.lineSeparator()
                        + "7. EXIT" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7"}
        );
        ItemRepositoryInterface itemRepository = new ItemRepository();
        itemRepository.clearAll();
        List<UserAction> actions = Arrays.asList(
                new ExitAction(out));
        Application application = new Application();
        application.setItemRepositoryInterface(itemRepository);
        application.setOutput(out);
        application.setInput(in);
        application.setActions(actions);
        application.start();
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "7. EXIT" + System.lineSeparator()));
    }

//    @Test (expected = IllegalArgumentException.class)
//    public void whenInvalidExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(new String[]{"1", "7"});
//        ItemRepositoryInterface itemRepository = new ItemRepository();
//        List<UserAction> actions = Arrays.asList(
//                new ExitAction(out));
//        Application application = new Application();
//        application.setItemRepositoryInterface(itemRepository);
//        application.setOutput(out);
//        application.setInput(in);
//        application.setActions(actions);
//        application.start();
//    }
}