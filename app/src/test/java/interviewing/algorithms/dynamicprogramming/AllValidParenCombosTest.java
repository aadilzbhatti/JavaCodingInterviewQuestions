package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AllValidParenCombosTest {

    @Test
    public void test() {
        Set<String> output = AllValidParenCombos.getAllValidParenCombos(3);
        Set<String> expected = Set.of(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        );
        assertTrue(expected.containsAll(output));
        assertTrue(output.containsAll(expected));
    }
}