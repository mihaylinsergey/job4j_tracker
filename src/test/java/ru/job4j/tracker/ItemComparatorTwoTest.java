package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemComparatorTwoTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(new Item(2, "Two"), new Item(1, "One"),
                new Item(4, "Four"));
        Collections.sort(items, new ItemComparatorTwo());
        List<Item> expect = Arrays.asList(new Item(4, "Four"), new Item(2, "Two"),
                new Item(1, "One"));
        assertThat(items, is(expect));
    }
}