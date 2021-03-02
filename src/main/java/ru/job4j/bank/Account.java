package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счёта
 * @author KHLAPOV DMITRII
 * @version 1.0
 */
public class Account {
    /**
     * Идентификатор счёта для хранения денег
     */
    private String requisite;
    /**
     * Балланс денег на счёте
     */
    private double balance;

    /**
     * Конструктор принимает на вход идентификатор счёта и сумму денег.
     * @param requisite идентификатор счёта для хранения денег
     * @param balance балланс денег на счёте
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает идентификатор счёта
     * @return идентификатор счёта для хранения денег
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод назначает идентификатор счёта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает балланс на счёте
     * @return балланс денег на счёте
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает балланс на счёте
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод производит сравнение объектов банковских счетов
     * по значению идентификатора счёта
     * @param o сравниваемый объект банковского счёта
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
