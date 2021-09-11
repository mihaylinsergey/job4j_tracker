package ru.job4j.oop;

public class Programmer extends Engineer{
    private String language;

    public Programmer(String name, String surname, String education,
                      String birthday, String university, String language) {
        super(name, surname, education, birthday, university);
        this.language = language;
    }

    public void workplace (Adress street) {
    }
}