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

public class TowerOfHanoiTest {

    @ParameterizedTest
    @MethodSource("towerOfHanoiDataProvider")
    public void testTowerOfHanoi(int n, int expectedMoves) {
        Deque<Integer> outputStack = new ArrayDeque<>();
        int outputMoves = TowerOfHanoi.towerOfHanoi(n, outputStack);
        assertEquals(expectedMoves, outputMoves);
        assertSortedInReverseOrder(new ArrayList<>(outputStack));
    }

    private void assertSortedInReverseOrder(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) >= list.get(i + 1));
        }
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
