package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.printInfo();
        Error error2 = new Error(true, 2, "Error #2");
        error2.printInfo();
        Error error3 = new Error(false, 3, "Error#3");
        error3.printInfo();
    }
}
