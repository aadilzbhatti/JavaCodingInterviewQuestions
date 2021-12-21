package interviewing.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeIntervalsTest {

    @ParameterizedTest
    @MethodSource("mergeIntervalsDataProvider")
    public void test(MergeIntervals.Interval[] intervals, MergeIntervals.Interval intervalToAdd, MergeIntervals.Interval[] expected) {
        MergeIntervals.Interval[] output = MergeIntervals.mergeIntervals(intervals, intervalToAdd);
        assertIntervalsEqual(expected, output);
    }

    private void assertIntervalsEqual(MergeIntervals.Interval[] arr1, MergeIntervals.Interval[] arr2) {
        assertEquals(arr1.length, arr2.length);
        for (int i = 0; i < arr1.length; i++) {
            MergeIntervals.Interval i1 = arr1[i];
            MergeIntervals.Interval i2 = arr2[i];
            assertEquals(i1.start, i2.start);
            assertEquals(i1.end, i2.end);
        }
    }

    private static Stream<Arguments> mergeIntervalsDataProvider() {
        return Stream.of(
                Arguments.of(
                        new MergeIntervals.Interval[] {
                                new MergeIntervals.Interval(-4, -1),
                                new MergeIntervals.Interval(0, 2),
                                new MergeIntervals.Interval(3, 6),
                                new MergeIntervals.Interval(7, 9),
                                new MergeIntervals.Interval(11, 12),
                                new MergeIntervals.Interval(14, 17),
                        },
                        new MergeIntervals.Interval(1, 8),
                        new MergeIntervals.Interval[] {
                                new MergeIntervals.Interval(-4, -1),
                                new MergeIntervals.Interval(0, 9),
                                new MergeIntervals.Interval(11, 12),
                                new MergeIntervals.Interval(14, 17)
                        }
                )
        );
    }
}