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

    @Test
    public void distance3dOne() {
        Point c = new Point(0, 0, 0);
        Point d = new Point(0, 3, 6);
        double dist3d = c.distance3d(d);
        assertThat(dist3d, closeTo(6.708, 0.001));
    }

    @Test
    public void distance3dTwo() {
        Point c = new Point(1, 2, 3);
        Point d = new Point(4, 5, 6);
        double dist3d = c.distance3d(d);
        assertThat(dist3d, closeTo(5.196, 0.001));
    }
}