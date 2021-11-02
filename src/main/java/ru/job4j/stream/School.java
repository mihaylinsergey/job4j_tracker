package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> rsl = students.stream()
                .filter(predict)
                .collect(Collectors.toList());
        return rsl;
    }

    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e,
                        (f, s) -> f));
    }
}
