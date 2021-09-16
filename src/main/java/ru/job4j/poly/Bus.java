package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void drive() {

    }

    @Override
    public void passengers() {

    }

    @Override
    public double fill(double gas) {
        return gas * 45.45;
    }
}
