package interviewing.algorithms.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursiveMultiplyTest {

    @ParameterizedTest
    @MethodSource("recursiveMultiplyDataProvider")
    public void testRecursiveMultiply(int x, int y, int res) {
        int output = RecursiveMultiply.recursiveMultiply(x, y);
        assertEquals(res, output);
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
}
