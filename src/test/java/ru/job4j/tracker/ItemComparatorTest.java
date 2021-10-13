package ru.job4j.tracker;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemComparatorTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(new Item(2, "Two"), new Item(1, "One"),
                new Item(4, "Four"));
        Collections.sort(items, new ItemComparator());
        List<Item> expect = Arrays.asList(new Item(1, "One"), new Item(2, "Two"),
                new Item(4, "Four"));
        assertThat(items, is(expect));
    }
}