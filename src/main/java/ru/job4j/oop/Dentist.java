package ru.job4j.oop;

public class Dentist extends Doctor{
    private String clinic;

    public Dentist(String name, String surname, String education,
                   String birthday, String specialization, String clinic){
        super(name, surname, education, birthday, specialization);
        this.clinic = clinic;
    }

    public void implantation (Pacient pacient) {
    }

}
