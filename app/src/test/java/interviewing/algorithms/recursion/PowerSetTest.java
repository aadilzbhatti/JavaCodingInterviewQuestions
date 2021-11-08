package interviewing.algorithms.recursion;

import interviewing.algorithms.recursion.PowerSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerSetTest {

    @ParameterizedTest
    @MethodSource("powerSetDataProvider")
    public void testPowerSet(Set<Integer> input, Set<Set<Integer>> output) {
        Set<Set<Integer>> powerSet = PowerSet.getPowerSet(input);
        assertEquals(output, powerSet);
    }

    @ParameterizedTest
    @MethodSource("powerSetDataProvider")
    public void testPowerSetRecursive(Set<Integer> input, Set<Set<Integer>> output) {
        Set<Set<Integer>> powerSet = PowerSet.powerSetRecursive(input);
        assertEquals(output, powerSet);
    }

    public static Stream<Arguments> powerSetDataProvider() {
        return Stream.of(
                Arguments.of(
                        new HashSet<>(Arrays.asList(1, 2, 3)),
                        new HashSet<Set<Integer>>(
                                Arrays.asList(
                                        Collections.emptySet(),
                                        new HashSet<>(Collections.singletonList(1)),
                                        new HashSet<>(Collections.singletonList(2)),
                                        new HashSet<>(Collections.singletonList(3)),
                                        new HashSet<>(Arrays.asList(1, 2)),
                                        new HashSet<>(Arrays.asList(2, 3)),
                                        new HashSet<>(Arrays.asList(1, 3)),
                                        new HashSet<>(Arrays.asList(1, 2, 3))
                                )
                        )
                )
        );
    }
}