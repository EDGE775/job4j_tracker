package ru.job4j.tracker;

import ru.job4j.tracker.action.ActionFactory;
import ru.job4j.tracker.data.repository.ItemRepository;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

public class ApplicationConfig {
    public static void config(Application application) {
        Output output = new ConsoleOutput();
        application.setInput(new ValidateInput(output, new ConsoleInput()));
        application.setOutput(output);
        application.setActions(ActionFactory.getFactory(output).createAllExistUserAction());
        application.setItemRepositoryInterface(new ItemRepository());
    }
}
