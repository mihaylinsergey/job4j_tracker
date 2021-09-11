package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student girls = new Student();
        girls.setName("Ivanova M.I.");
        girls.setGroup("№1");
        girls.setCreated(new Date());
        System.out.println("Ф.И.О.: " + girls.getName() + " группа: "
                + girls.getGroup() + " дата поступления " + girls.getCreated());

    }
}
