package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String office;

    public Surgeon(String name, String surname, String education,
                   String birthday, String specialization, String office) {
        super(name, surname, education, birthday, specialization);
        this.office = office;
    }

    public void operation(Pacient pacient) {
    }

}
