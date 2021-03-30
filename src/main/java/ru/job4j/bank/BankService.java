package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * @author KHLAPOV DMITRII
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей банка осуществляется в коллекции типа HashMap.
     * Это поле содержит всех пользователей системы с привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему, если в системе его ещё нет.
     * @param user объект пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счёт к пользователю, если такого счёта ещё нет.
     * @param passport номер паспорта пользователя
     * @param account объект добавляемого банковского счёта
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = this.findByPassport(passport);
        if (user.isEmpty()) {
            return;
        }
        List<Account> usersAccounts = users.get(user.get());
        if (!usersAccounts.contains(account)) {
            usersAccounts.add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта пользователя
     * @return возвращает объект пользователя, в случае успешного нахождения.
     * Иначе возврашает null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет пользователя по реквизитам.
     * @param passport номер паспорта пользователя
     * @param requisite идентификатор счёта пользователя
     * @return возвращает объект банковского счёта, в случае успешного нахождения.
     * Иначе возврашает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = this.findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой.
     * @param srcPassport номер паспорта пользователя, который переводит деньги
     * @param srcRequisite идентификатор счёта пользователя, с которого переводятся деньги
     * @param destPassport номер паспорта пользователя, которому переводят деньги
     * @param destRequisite идентификатор счёта пользователя, на который переводятся деньги
     * @param amount количество переводимых денег
     * @return в случае успешной операции возвращает true. Иначе false
     */
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = this.findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = this.findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
