package interviewing.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayPermutationsTest {

    @Test
    public void testPermutations() {
        List<List<Integer>> out = ArrayPermutations.getPermutations(4);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 4, 3),
                Arrays.asList(1, 3, 2, 4),
                Arrays.asList(1, 3, 4, 2),
                Arrays.asList(1, 4, 2, 3),
                Arrays.asList(1, 4, 3, 2),
                Arrays.asList(2, 1, 3, 4),
                Arrays.asList(2, 1, 4, 3),
                Arrays.asList(2, 3, 4, 1),
                Arrays.asList(2, 3, 1, 4),
                Arrays.asList(2, 4, 1, 3),
                Arrays.asList(2, 4, 3, 1),
                Arrays.asList(3, 2, 1, 4),
                Arrays.asList(3, 2, 4, 1),
                Arrays.asList(3, 1, 2, 4),
                Arrays.asList(3, 1, 4, 2),
                Arrays.asList(3, 4, 1, 2),
                Arrays.asList(3, 4, 2, 1),
                Arrays.asList(4, 3, 2, 1),
                Arrays.asList(4, 3, 1, 2),
                Arrays.asList(4, 1, 2, 3),
                Arrays.asList(4, 1, 3, 2),
                Arrays.asList(4, 2, 3, 1),
                Arrays.asList(4, 2, 1, 3)
        );

        assertEquals(expected.size(), out.size());
        for (List<Integer> expectedPermutation : expected) {
            assertTrue(out.contains(expectedPermutation));
        }
    }
}