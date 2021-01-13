package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the Item id to find: ");
        Item item = tracker.findById(id);
        String rsl = item == null ? "Заявка с таким id не найдена" : item.toString();
        System.out.println(rsl);
        return true;
    }
}
