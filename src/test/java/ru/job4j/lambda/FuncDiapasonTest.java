package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FuncDiapasonTest {

    @Test
    public void whenLinearFunction() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> x * x);
        List<Double> expected = List.of(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> Math.pow(x, x));
        List<Double> expected = List.of(3125D, 46656D, 823543D);
        assertThat(result, is(expected));
    }
}