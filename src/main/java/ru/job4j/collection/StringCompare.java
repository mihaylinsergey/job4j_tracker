package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leng = Math.min(left.length(), right.length());
        for (int i = 0; i < leng; i++) {
            char a = left.charAt(i);
            char b = right.charAt(i);
            if (a != b) {
                return Character.compare(a, b);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}