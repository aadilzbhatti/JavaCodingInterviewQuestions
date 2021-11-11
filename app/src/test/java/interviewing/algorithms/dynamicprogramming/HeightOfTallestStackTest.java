package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightOfTallestStackTest {

    @ParameterizedTest
    @MethodSource("heightOfTallestStackDataProvider")
    public void testHeightOfTallestStackRecursive(HeightOfTallestStack.Box[] boxes, int expected) {
        int height = HeightOfTallestStack.getHeightOfTallestStackRecursive(boxes);
        assertEquals(expected, height);
    }

    @ParameterizedTest
    @MethodSource("heightOfTallestStackDataProvider")
    public void testHeightOfTallestStackDynamic(HeightOfTallestStack.Box[] boxes, int expected) {
        int height = HeightOfTallestStack.getHeightOfTallestStackDynamic(boxes);
        assertEquals(expected, height);
    }

    private static Stream<Arguments> heightOfTallestStackDataProvider() {
        return Stream.of(
                Arguments.of(
                        new HeightOfTallestStack.Box[] {
                                new HeightOfTallestStack.Box(5, 10, 15),
                                new HeightOfTallestStack.Box(21, 12, 4),
                                new HeightOfTallestStack.Box(11, 3, 3),
                                new HeightOfTallestStack.Box(8, 11, 16)
                        },
                        32
                ),
                Arguments.of(
                        new HeightOfTallestStack.Box[] {
                                new HeightOfTallestStack.Box(5, 9, 8),
                                new HeightOfTallestStack.Box(21, 12, 4),
                                new HeightOfTallestStack.Box(11, 13, 3),
                                new HeightOfTallestStack.Box(8, 8, 16)
                        },
                        21
                ),
                Arguments.of(
                        new HeightOfTallestStack.Box[] {
                                new HeightOfTallestStack.Box(5, 9, 8),
                                new HeightOfTallestStack.Box(21, 12, 4),
                                new HeightOfTallestStack.Box(11, 3, 3),
                                new HeightOfTallestStack.Box(8, 8, 16),
                                new HeightOfTallestStack.Box(14, 9, 8),
                                new HeightOfTallestStack.Box(32, 14, 18),
                                new HeightOfTallestStack.Box(64, 18, 20)
                        },
                        128
                )
        );
    }
}