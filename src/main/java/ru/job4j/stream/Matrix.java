package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    public static List<Integer> matrixToList(Integer[][] nums) {
        List<Integer> rsl = Arrays.stream(nums)
                .flatMap(e -> Stream.of(e))
                .collect(Collectors.toList());
        return rsl;
    }
}
