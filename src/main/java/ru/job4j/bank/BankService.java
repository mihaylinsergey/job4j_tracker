package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     */

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *
     * @param user этот метод должен добавить пользователя в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());

    }

    /**
     * метод должен добавить новый счет к пользователю
     * @param passport параметр пользователя
     * @param account параметр пользователя
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * метод ищет пользователя по номеру паспорта
     * @param passport параметр пользователя
     * @return возвращает параметры пользователя
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User el : users.keySet()) {
            if (el.getPassport().equals(passport)) {
                rsl = el;
                break;
            }
        }
        return rsl;
    }

    /**
     * метод ищет счет пользователя по реквизитам
     * @param passport параметр искомого пользователя
     * @param requisite параметр искомого аккаунта
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : users.get(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    account = acc;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя, со счета которого осуществляется перевод
     * @param srcRequisite реквизиты пользователя, со счета которого осуществляется перевод
     * @param destPassport паспорт пользователя, которому осуществляется перевод
     * @param destRequisite реквизиты пользователя, которому осуществляется перевод
     * @param amount сумма перевода
     * @return возвращает сведения об успешности перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}
