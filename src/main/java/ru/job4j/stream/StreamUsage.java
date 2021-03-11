package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }
    public static void main(String[] args) {
        //Код из предыдущего задания:
        //List<Integer> list = List.of(1, 3, -6, 7, -10);
        //List<Integer> numbers = new ArrayList<>(list);
        //List<Integer> fltNumbers = numbers.stream()
        //        .filter(number -> number > 0)
        //        .collect(Collectors.toList());

        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);
    }
}
