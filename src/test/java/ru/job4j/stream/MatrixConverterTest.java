package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixConverterTest {

    @Test
    public void when2Elements() {
        Integer[][] numbers = {
                {1, 8},
                {2, 4}
        };
        List<Integer> rsl = MatrixConverter.convert(numbers);
        List<Integer> expect = List.of(1, 8, 2, 4);
        assertThat(rsl, is(expect));
    }

    @Test
    public void when1Elements() {
        Integer[][] numbers = {
                {1, 8},
        };
        List<Integer> rsl = MatrixConverter.convert(numbers);
        List<Integer> expect = List.of(1, 8);
        assertThat(rsl, is(expect));
    }
}