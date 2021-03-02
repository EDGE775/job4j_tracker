package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 * @author KHLAPOV DMITRII
 * @version 1.0
 */
public class User {
    /**
     * Номер паспорта пользователя
     */
    private String passport;
    /**
     * Полное имя пользователя
     */
    private String username;

    /**
     * Конструктор принимает на вход номер паспорта пользователя и полное имя.
     * @param passport номер паспорта пользователя
     * @param username полное имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает номер паспорта пользователя
     * @return номер паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод назначает номер паспорта пользователя
     * @param passport номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает полное имя пользователя
     * @return полное имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод назначает полное имя пользователя
     * @param username полное имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод производит сравнение объектов пользователей
     * по значению номера паспорта
     * @param o сравниваемый объект пользователя
     * @return возвращает true, если объекты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
