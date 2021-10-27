package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayStream {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, -2, 3, -4, 5, -6, 7);
        List<Integer> rsl = nums.stream().filter(
                num -> num > 0).collect(Collectors.toList());
        System.out.println(rsl);
    }
}
