package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(new ShowAction(out),
                new ExitAction());
        String ln = System.lineSeparator();
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "test1", "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindByNameAction(out),
                new ExitAction());
        String ln = System.lineSeparator();
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindByIdAction(out),
                new ExitAction());
        String ln = System.lineSeparator();
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ====" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu." + ln
                                + "0. Exit" + ln
                )
        );
    }

    @Test
    public void executeReplaceActionWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ====" + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void executeDeleteActionWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        DeleteAction del = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===="
                + ln + "Заявка удалена успешно." + ln));
    }

    @Test
    public void executeFindByIDActionWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New item");
        tracker.add(item);
        FindByIdAction rsl = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        rsl.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ====" + ln + item + ln));
    }

    @Test
    public void executeFindByNameActionWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New item");
        tracker.add(item);
        FindByNameAction rsl = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("New item");
        rsl.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln + item + ln));
    }
}
