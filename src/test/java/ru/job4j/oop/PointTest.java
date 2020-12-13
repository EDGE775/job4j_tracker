package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenDistance1() {
        Point first = new Point(1, 0, 0);
        Point second = new Point(0, 0, 0);
        double rsl = first.distance3D(second);
        assertThat(rsl, is((double)1));
    }

    @Test
    public void whenDistance6() {
        Point first = new Point(1, 5, 0);
        Point second = new Point(1, 5, 6);
        double rsl = first.distance3D(second);
        assertThat(rsl, is((double)6));
    }
}