package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user == null) return;
        List<Account> usersAccounts = users.get(user);
        if (!usersAccounts.contains(account)) {
            usersAccounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        List<User> usersList = new ArrayList<User>(users.keySet());
        int index = usersList.indexOf(new User(passport, "Unknown"));
        return index == -1 ? null : usersList.get(index);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = this.findByPassport(passport);
        if (user == null) return null;
        List<Account> usersAccounts = users.get(user);
        int index = usersAccounts.indexOf(new Account(requisite, 0D));
        return index == -1 ? null : usersAccounts.get(index);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = this.findByRequisite(srcPassport, srcRequisite);
        Account destAccount = this.findByRequisite(destPassport, destRequisite);
        if (srcAccount != null || destAccount != null || srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
