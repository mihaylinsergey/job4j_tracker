package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item(2, "Two"), new Item(1, "One"),
                new Item(4, "Four"));
        System.out.println(items);
        Collections.sort(items, new ItemComparator());
        System.out.println(items);
    }
}