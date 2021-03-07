package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        if (o1Array[0].equals(o2Array[0])) {
            return o1.compareTo(o2);
        }
        return o2Array[0].compareTo(o1Array[0]);
    }
}
