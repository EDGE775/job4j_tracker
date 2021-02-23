package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void whenTrueAdd() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenFalseAdd() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Arsentev Petr");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        assertThat(office.add(citizen2), is(false));
    }
}