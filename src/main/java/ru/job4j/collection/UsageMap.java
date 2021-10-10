package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        names.put("III@gmail.ru", "Ivan Ivanovich Ivanov");
        names.put("PPP@mail.ru", "Petr Petrovich Petrov");
        for (String mail : names.keySet()) {
            System.out.println(mail + " = " + names.get(mail));
        }
    }
}
