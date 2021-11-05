package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * метод ищет пользователя по номеру паспорта
     * @param passport параметр пользователя
     * @return возвращает объект -  пользователя
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * метод ищет счет пользователя по реквизитам
     * @param passport параметр искомого пользователя
     * @param requisite параметр искомого аккаунта
     * @return возвращает объект счета пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
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
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent() && accountDest.isPresent()
                && accountSrc.get().getBalance() >= amount) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}
