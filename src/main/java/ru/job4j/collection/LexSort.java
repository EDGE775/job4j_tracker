package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl;
        String[] leftArray = left.split(" ")[0].split("\\.");
        String[] rightArray = right.split(" ")[0].split("\\.");
        for (int i = 0; i < Math.min(leftArray.length, rightArray.length); i++) {
            try {
                int leftNumber = Integer.parseInt(leftArray[i]);
                int rightNumber = Integer.parseInt(rightArray[i]);
                rsl = Integer.compare(leftNumber, rightNumber);
            } catch (Exception exp) {
                continue;
            }
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(leftArray.length, rightArray.length);
    }
}