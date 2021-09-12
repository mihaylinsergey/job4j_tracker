package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
    Item[] findItems = new Item[size];
        for (int i = 0; i < size; i++) {
            findItems[i] = items[i];
        }
        findItems = Arrays.copyOf(findItems, size);
        return findItems;
    }

    public Item[] findByName(String key) {
    Item[] nameItems = new Item[size];
    int nameSize = 0;
        for (int i = 0; i < size; i++) {
            Item tmp = items[i];
            if (tmp.getName().equals(key)) {
                nameItems[nameSize] = items[i];
                nameSize++;
            }
        }
        nameItems = Arrays.copyOf(nameItems, nameSize);
        return nameItems;
    }
}