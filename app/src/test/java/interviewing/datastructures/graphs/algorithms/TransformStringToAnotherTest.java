package interviewing.datastructures.graphs.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransformStringToAnotherTest {

    @Test
    public void test() {
        List<String> dictionary = Arrays.asList("bat", "cot", "dog", "dag", "dot", "cat");
        String start = "cat";
        String end = "dog";
        int shortestProductionSequence = TransformStringToAnother.shortestProductionSequence(start, end, dictionary);

        assertEquals(4, shortestProductionSequence);
    }
}