package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String el : origin) {
            check.add(el);
        }
        for (String el : duplicate) {
            if (!check.contains(el)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
