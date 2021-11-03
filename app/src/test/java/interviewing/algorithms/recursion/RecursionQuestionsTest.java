package interviewing.algorithms.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecursionQuestionsTest {

    @ParameterizedTest
    @MethodSource("magicIndexDataProvider")
    public void testMagicIndex(int[] arr, boolean hasMagicIndex) {
        int magicIndex = RecursionQuestions.findMagicIndex(arr);
        assertEquals(hasMagicIndex, magicIndex != -1);
    }

    @ParameterizedTest
    @MethodSource("recursiveMultiplyDataProvider")
    public void testRecursiveMultiply(int x, int y, int res) {
        int output = RecursionQuestions.recursiveMultiply(x, y);
        assertEquals(res, output);
    }

    @ParameterizedTest
    @MethodSource("towerOfHanoiDataProvider")
    public void testTowerOfHanoi(int n, int expectedMoves) {
        Deque<Integer> outputStack = new ArrayDeque<>();
        int outputMoves = RecursionQuestions.towerOfHanoi(n, outputStack);
        assertEquals(expectedMoves, outputMoves);
        assertSortedInReverseOrder(new ArrayList<>(outputStack));
    }

    private void assertSortedInReverseOrder(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) >= list.get(i + 1));
        }
    }

    private static Stream<Arguments> magicIndexDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 0, 1, 2, 3, 5, 10, 11, 12, 14 },
                        true
                ),
                Arguments.of(
                        new int[] { 1, 2, 3, 4, 5, 10, 11, 12, 14 },
                        false
                ),
                Arguments.of(
                        new int[] { 0, 2, 4, 5, 6, 10, 11, 12, 14 },
                        true
                )
        );
    }

    private static Stream<Arguments> recursiveMultiplyDataProvider() {
        return Stream.of(
                Arguments.of(
                        3,
                        4,
                        12
                ),
                Arguments.of(
                        3,
                        0,
                        0
                ),
                Arguments.of(
                        1,
                        1,
                        1
                ),
                Arguments.of(
                        0,
                        0,
                        0
                )
        );
    }

    private static Stream<Arguments> towerOfHanoiDataProvider() {
        return Stream.of(
                Arguments.of(
                        1,
                        1
                ),
                Arguments.of(
                        0,
                        0
                ),
                Arguments.of(
                        2,
                        3
                ),
                Arguments.of(
                        3,
                        7
                ),
                Arguments.of(
                        4,
                        15
                ),
                Arguments.of(
                        5,
                        31
                )
        );
    }
}
