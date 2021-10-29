package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comparator = new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        };
        List<Address> rsl = profiles.stream()
                .map(x -> x.getAddress())
                .sorted(comparator)
                .distinct()
                .collect(Collectors.toList());
        return rsl;
    }
}
