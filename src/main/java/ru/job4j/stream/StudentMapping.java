package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentMapping {
    public static Map<String, Student> mapping(List<Student> list) {
        return list.stream().
                collect(Collectors.toMap(
                        Student::getSurname,
                        Function.identity(),
                        (x, y) -> x));
    }
}
