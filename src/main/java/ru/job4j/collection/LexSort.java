package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] a = left.split("\\.");
        String[] b = right.split("\\.");
        return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
    }
}