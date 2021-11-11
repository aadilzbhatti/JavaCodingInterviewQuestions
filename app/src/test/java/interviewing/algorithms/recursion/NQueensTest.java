package interviewing.algorithms.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NQueensTest {

    @Test
    public void test() {
        List<List<Integer>> out = NQueens.placeQueens(8);
        assertEquals(92, out.size());
    }
}