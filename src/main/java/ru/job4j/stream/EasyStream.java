package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> values;

    private EasyStream(List<Integer> source) {
        this.values = source;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer value : values) {
            rsl.add(fun.apply(value));
        }
        this.values = rsl;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer value : values) {
            if (fun.test(value)) {
                rsl.add(value);
            }
        }
        this.values = rsl;
        return this;
    }

    public List<Integer> collect() {
        return values;
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(2, 5, 2, 1, 5, 1);
        System.out.println(values);
        List<Integer> rsl = EasyStream.of(values)
                .map(x -> x * 2)
                .filter(x -> x > 2)
                .collect();
        System.out.println(rsl);
    }
}