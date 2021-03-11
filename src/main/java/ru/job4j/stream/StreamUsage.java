package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, -6, 7, -10);
        List<Integer> numbers = new ArrayList<>(list);
        List<Integer> fltNumbers = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
    }
}
