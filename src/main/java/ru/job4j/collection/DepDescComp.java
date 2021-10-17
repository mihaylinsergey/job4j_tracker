package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        int rsl = 0;
        int length = Math.min(left.length, right.length);
        for (int i = 0; i < length; i++) {
            if (left[0].equals(right[0])) {
                rsl = o1.compareTo(o2);
            } else {
                rsl = o2.compareTo(o1);
            }
        }
        return rsl;
    }
}