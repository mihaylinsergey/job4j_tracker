package ru.job4j.poly;

public class Plane implements Vehicle{
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам");
    }
}
