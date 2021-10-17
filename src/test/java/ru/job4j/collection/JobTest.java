package ru.job4j.collection;


import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void jobDescByNameInc() {
        Comparator<Job> jobDescByNameInc = new JobDescByNameInc();
        int rsl = jobDescByNameInc.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void jobDescByNameDec() {
        Comparator<Job> jobDescByNameDec = new JobDescByNameDec();
        int rsl = jobDescByNameDec.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void jobDescByPriorityInc() {
        Comparator<Job> jobDescByPriorityInc = new JobDescByPriorityInc();
        int rsl = jobDescByPriorityInc.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void jobDescByPriorityDec() {
        Comparator<Job> jobDescByPriorityDec = new JobDescByPriorityDec();
        int rsl = jobDescByPriorityDec.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByNameInc().thenComparing(new JobDescByPriorityInc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}