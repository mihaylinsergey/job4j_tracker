package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerHbmTest {

    @AfterEach
    public void cleanTableItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            var list = tracker.findAll();
            for (Item i : list) {
                tracker.delete(i.getId());
            }
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenTestFindById() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item bug = new Item("Bug");
            Item item = tracker.add(bug);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenTestFindAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            tracker.add(first);
            tracker.add(second);
            List<Item> result = tracker.findAll();
            assertThat(result.get(0).getName(), is("First"));
        }
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker memTracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        memTracker.add(first);
        memTracker.add(second);
        memTracker.add(new Item("First"));
        memTracker.add(new Item("Second"));
        memTracker.add(new Item("First"));
        List<Item> result = memTracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}
