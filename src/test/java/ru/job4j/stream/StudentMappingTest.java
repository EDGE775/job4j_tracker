package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StudentMappingTest {

    @Test
    public void whenDoubleSurnames() {
        List<Student> studList = new ArrayList<>();
        studList.add(new Student(50, "Пупкин"));
        studList.add(new Student(40, "Пупкин"));
        studList.add(new Student(60, "Васечкин"));
        studList.add(new Student(100, "Петров"));
        studList.add(new Student(100, "Пупкин"));
        studList.add(new Student(50, "Петров"));
        Map<String, Student> studMap = StudentMapping.mapping(studList);
        Map<String, Student> expect = Map.of(
                "Пупкин", new Student(50, "Пупкин"),
                "Васечкин", new Student(60, "Васечкин"),
                "Петров", new Student(100, "Петров"));
        assertThat(studMap, is(expect));
    }
}