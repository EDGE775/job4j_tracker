package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.AbstractUserAction;
import ru.job4j.tracker.action.Action;
import ru.job4j.tracker.data.repository.ItemRepositoryInterface;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.data.entity.Item;

public class FindItemByIdAction extends AbstractUserAction {
    public FindItemByIdAction(Output output) {
        super(Action.FIND_BY_ID, output);
    }

    @Override
    public boolean execute(Input input, ItemRepositoryInterface itemRepository) {
        out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter the Item id to find: ");
        Item item = itemRepository.findById(id);
        String rsl = item == null ? "Заявка с таким id не найдена" : item.toString();
        out.println(rsl);
        return true;
    }
}
