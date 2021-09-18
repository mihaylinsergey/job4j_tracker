package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void drive() {
        System.out.println("Едет от остановки к остановке");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Перевозит"  + quantity + " пассажиров");
    }

    @Override
    public double fill(double gas) {
        return gas * 45.45;
    }
}
