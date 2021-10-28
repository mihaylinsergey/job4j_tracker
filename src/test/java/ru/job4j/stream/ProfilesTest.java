package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address address1 = new Address("citi1", "street1", 1, 1);
        Address address2 = new Address("citi2", "street2", 2, 2);
        Address address3 = new Address("citi3", "street3", 3, 3);
        List<Profile> profiles = List.of(new Profile(address1), new Profile(address2),
                new Profile(address3));
        Profiles iter = new Profiles();
        List<Address> rsl = iter.collect(profiles);
        List<Address> exp = List.of(address1, address2, address3);
        assertThat(rsl, is(exp));
    }
}