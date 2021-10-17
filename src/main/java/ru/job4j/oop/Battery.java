package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(90);
        Battery second = new Battery(10);
        System.out.println("Начальный заряд батареи:" + first.load);
        first.exchange(second);
        System.out.println("Текущий заряд батареи:"
                + first.load + "  Израсходовано:" + second.load);

    }
}