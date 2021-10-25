package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare" + right.getSize() + ":" + left.getSize());
            return Integer.compare(right.getSize(), left.getSize());
        };
    }
}

