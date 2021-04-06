package ru.job4j.tracker;

import ru.job4j.tracker.data.entity.Item;
import ru.job4j.tracker.data.repository.ItemRepository;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, ItemRepository itemRepository) {
        out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter the Item id to find: ");
        Item item = itemRepository.findById(id);
        String rsl = item == null ? "Заявка с таким id не найдена" : item.toString();
        out.println(rsl);
        return true;
    }
}
