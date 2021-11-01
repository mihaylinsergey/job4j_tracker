package ru.job4j.stream;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.List;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void matrixToList() {
        Integer[][] nums = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        List<Integer> rsl = Matrix.matrixToList(nums);
        List<Integer> exp = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(rsl, is(exp));
    }
}