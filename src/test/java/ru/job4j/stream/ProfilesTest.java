package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenNotEmptyList() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("Москва", "Юности", 1, 12)));
        profiles.add(new Profile(new Address("Тула", "Проспект мира", 12, 41)));
        List<Address> result = Profiles.collect(profiles);
        List<Address> expect = List.of(
                new Address("Москва", "Юности", 1, 12),
                new Address("Тула", "Проспект мира", 12, 41)
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenEmptyList() {
        List<Profile> profiles = new ArrayList<>();
        List<Address> result = Profiles.collect(profiles);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenTheSameAddress() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("Москва", "Юности", 1, 12)));
        profiles.add(new Profile(new Address("Тула", "Проспект мира", 12, 41)));
        profiles.add(new Profile(new Address("Тула", "Проспект мира", 12, 41)));
        List<Address> result = Profiles.collect(profiles);
        List<Address> expect = List.of(
                new Address("Москва", "Юности", 1, 12),
                new Address("Тула", "Проспект мира", 12, 41)
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortedAddress() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("Москва", "Юности", 1, 12)));
        profiles.add(new Profile(new Address("Тула", "Проспект мира", 12, 41)));
        profiles.add(new Profile(new Address("Архангельск", "Проспект инжира", 12, 41)));
        List<Address> result = Profiles.collect(profiles);
        List<Address> expect = List.of(
                new Address("Архангельск", "Проспект инжира", 12, 41),
                new Address("Москва", "Юности", 1, 12),
                new Address("Тула", "Проспект мира", 12, 41)
        );
        assertThat(result, is(expect));
    }
}