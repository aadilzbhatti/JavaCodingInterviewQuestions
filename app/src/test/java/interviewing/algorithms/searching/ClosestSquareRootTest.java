package interviewing.algorithms.searching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClosestSquareRootTest {

    @ParameterizedTest
    @MethodSource("closestSquareRootDataProvider")
    public void test(int val, int expected) {
        int root = ClosestSquareRoot.closestSquareRoot(val);
        assertEquals(expected, root);
    }

    private static Stream<Arguments> closestSquareRootDataProvider() {
        return Stream.of(
                Arguments.of(16, 4),
                Arguments.of(300, 17),
                Arguments.of(500, 22),
                Arguments.of(1000, 31),
                Arguments.of(37464, 193)
        );
    }
}