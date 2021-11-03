package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripleStepTest {

    @Test
    public void testTripleStep() {
        assertEquals(27, TripleStep.countPossibleStepPatterns(5));
        assertEquals(7, TripleStep.countPossibleStepPatterns(3));
    }
}