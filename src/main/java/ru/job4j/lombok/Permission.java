package ru.job4j.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder(builderMethodName = "of")
@Data
public class Permission {
    private int id;
    private String name;
    @Singular("rules")
    private List<String> rules;
}
