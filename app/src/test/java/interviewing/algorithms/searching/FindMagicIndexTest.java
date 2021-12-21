package interviewing.algorithms.searching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMagicIndexTest {

    @ParameterizedTest
    @MethodSource("magicIndexDataProvider")
    public void testMagicIndex(int[] arr, boolean hasMagicIndex) {
        int magicIndex = FindMagicIndex.findMagicIndex(arr);
        assertEquals(hasMagicIndex, magicIndex != -1);
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
}
