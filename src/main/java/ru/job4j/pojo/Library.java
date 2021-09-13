package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("Красная", 10);
        Book two = new Book("Синяя", 20);
        Book three = new Book("Желтая", 30);
        Book four = new Book("Зеленая", 40);
        Book five = new Book("Clean code", 50);
        Book[] books = new Book[5];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        books[4] = five;
        for (int i = 0; i < books.length; i++) {
            Book bo = books[i];
            System.out.println(bo.getName() + " " + bo.getCount());
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book bo = books[i];
            System.out.println(bo.getName() + " " + bo.getCount());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book bo = books[i];
            if ("Clean code".equals(bo.getName())) {
                System.out.println(bo.getName() + " " + bo.getCount());
            }
        }
    }
}
