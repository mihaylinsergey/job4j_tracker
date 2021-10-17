package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle traine = new Traine();
        Vehicle bas = new Bas();
        Vehicle[] vehicles = new Vehicle[] {plane, traine, bas};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
