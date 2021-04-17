package ru.job4j.tracker.action;

import ru.job4j.tracker.action.impl.*;
import ru.job4j.tracker.output.Output;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActionFactory {
    private static Output OUTPUT;
    private static ActionFactory actionFactory;

    private ActionFactory(Output output) {
        OUTPUT = output;
    }

    public static ActionFactory getFactory(Output output) {
        if (actionFactory == null) {
            actionFactory = new ActionFactory(output);
        }
        return actionFactory;
    }

    public UserAction createAction(Action action) {
        switch (action) {
            case CREATE:
                return new CreateItemAction(OUTPUT);
            case EXIT:
                return new ExitAction(OUTPUT);
            case DELETE:
                return new DeleteItemAction(OUTPUT);
            case REPLACE:
                return new ReplaceItemAction(OUTPUT);
            case FIND_ALL:
                return new FindItemsAction(OUTPUT);
            case FIND_BY_ID:
                return new FindItemByIdAction(OUTPUT);
            case FIND_BY_NAME:
                return new FindItemsByNameAction(OUTPUT);
            default:
                throw new UnsupportedOperationException(String.format("Action '%s' not found.", action));
        }
    }

    public Collection<UserAction> createAllExistUserAction() {
        return Stream.of(Action.values())
                .map(actionFactory::createAction)
                .sorted(Comparator.comparingInt(UserAction::getOrder))
                .collect(Collectors.toList());
    }
}
