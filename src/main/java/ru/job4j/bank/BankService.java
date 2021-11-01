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
     * этот метод должен добавить пользователя в систему
     * @param user метод принимает объект нового пользователя
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
     * @return возвращает объект -  пользователя
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод ищет счет пользователя по реквизитам
     * @param passport параметр искомого пользователя
     * @param requisite параметр искомого аккаунта
     * @return возвращает объект счета пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
