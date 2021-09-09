package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void distance1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        assertThat(dist, closeTo(2, 0.001));

    }

    @Test
    public void distance2() {
        Point a = new Point(-2, 24);
        Point b = new Point(56, -99);
        double dist = a.distance(b);
        assertThat(dist, closeTo(135.9889, 0.001));
    }
}