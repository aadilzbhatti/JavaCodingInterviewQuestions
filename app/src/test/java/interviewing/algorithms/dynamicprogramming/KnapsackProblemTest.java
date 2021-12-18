package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackProblemTest {

    @ParameterizedTest
    @MethodSource("knapsackProblemDataProvider")
    public void testKnapsackProblemRecursive(List<KnapsackProblem.Clock> clocks, int maxWeight, int expectedValue) {
        int value = KnapsackProblem.computeOptimalValueRecursive(clocks, maxWeight);
        assertEquals(expectedValue, value);
    }

    @ParameterizedTest
    @MethodSource("knapsackProblemDataProvider")
    public void testKnapsackProblemLessRecursive(List<KnapsackProblem.Clock> clocks, int maxWeight, int expectedValue) {
        int value = KnapsackProblem.computeOptimalValueLessRecursive(clocks, maxWeight);
        assertEquals(expectedValue, value);
    }

    private static Stream<Arguments> knapsackProblemDataProvider() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new KnapsackProblem.Clock(65, 20),
                                new KnapsackProblem.Clock(35, 8),
                                new KnapsackProblem.Clock(245, 60),
                                new KnapsackProblem.Clock(195, 55),
                                new KnapsackProblem.Clock(65, 40),
                                new KnapsackProblem.Clock(150, 70),
                                new KnapsackProblem.Clock(275, 85),
                                new KnapsackProblem.Clock(155, 25),
                                new KnapsackProblem.Clock(120, 30),
                                new KnapsackProblem.Clock(320, 65),
                                new KnapsackProblem.Clock(75, 75),
                                new KnapsackProblem.Clock(40, 10),
                                new KnapsackProblem.Clock(200, 95),
                                new KnapsackProblem.Clock(100, 50),
                                new KnapsackProblem.Clock(220, 40),
                                new KnapsackProblem.Clock(99, 10)
                        ),
                        130,
                        695
                )
        );
    }
}