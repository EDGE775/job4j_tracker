package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SearchAtt {
    private static List<Attachment> filter(List<Attachment> list,
                                           Function<Attachment, Boolean> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (func.apply(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Function<Attachment, Boolean> func = new Function<Attachment, Boolean>() {
            @Override
            public Boolean apply(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, func);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Function<Attachment, Boolean> func = new Function<Attachment, Boolean>() {
            @Override
            public Boolean apply(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, func);
    }
}
