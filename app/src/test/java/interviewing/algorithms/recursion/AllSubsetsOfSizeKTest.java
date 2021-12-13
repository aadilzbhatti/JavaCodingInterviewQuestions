package interviewing.algorithms.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllSubsetsOfSizeKTest {

    @ParameterizedTest
    @MethodSource("allSizeKSubsetsDataProvider")
    public void test(int k, int n, Set<Set<Integer>> expected) {
        Set<Set<Integer>> out = AllSubsetsOfSizeK.getAllSubsetsOfSizeK(k, n);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> allSizeKSubsetsDataProvider() {
        return Stream.of(
                Arguments.of(
                        2, 5,
                        new HashSet<Set<Integer>>() {
                            {
                                add(Set.of(1, 2));
                                add(Set.of(1, 3));
                                add(Set.of(1, 4));
                                add(Set.of(1, 5));
                                add(Set.of(2, 3));
                                add(Set.of(2, 4));
                                add(Set.of(2, 5));
                                add(Set.of(3, 4));
                                add(Set.of(3, 5));
                                add(Set.of(4, 5));
                            }
                        }
                )
        );
    }
}