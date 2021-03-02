package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl;
        String[] leftArray = left.split(" ")[0].split("\\.");
        String[] rightArray = right.split(" ")[0].split("\\.");
        return Integer.compare(
                Integer.parseInt(leftArray[0]),
                Integer.parseInt(rightArray[0]));
    }
}