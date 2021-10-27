package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = (x) -> x.getName().contains(key);
        Predicate<Person> phone = (x) -> x.getPhone().contains(key);
        Predicate<Person> address = (x) -> x.getAddress().contains(key);
        Predicate<Person> surname = (x) -> x.getSurname().contains(key);
        Predicate<Person> combine = name.or(phone.or(address.or(surname)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }



    /*   public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key) || person.getPhone().contains(key)
                    || person.getAddress().contains(key) || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Ivan");
        System.out.println(persons);
    } */
}