package interviewing.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class OpenClosedIntervalTest {

    @ParameterizedTest
    @MethodSource("openClosedIntervalsDataProvider")
    public void test(List<OpenClosedInterval> intervals, List<OpenClosedInterval> expected) {
//        System.out.println(intervals);
        List<OpenClosedInterval> out = OpenClosedInterval.unionOfIntervals(intervals);
//        System.out.println(out);
    }

    private static Stream<Arguments> openClosedIntervalsDataProvider() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(0, true),
                                        new OpenClosedInterval.Endpoint(3, true)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(1, false),
                                        new OpenClosedInterval.Endpoint(1, false)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(2, false),
                                        new OpenClosedInterval.Endpoint(4, false)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(3, false),
                                        new OpenClosedInterval.Endpoint(4, true)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(5, false),
                                        new OpenClosedInterval.Endpoint(7, true)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(7, false),
                                        new OpenClosedInterval.Endpoint(8, true)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(8, false),
                                        new OpenClosedInterval.Endpoint(11, true)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(9, true),
                                        new OpenClosedInterval.Endpoint(11, false)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(12, false),
                                        new OpenClosedInterval.Endpoint(14, false)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(12, true),
                                        new OpenClosedInterval.Endpoint(16, false)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(13, true),
                                        new OpenClosedInterval.Endpoint(15, true)
                                ),
                                new OpenClosedInterval(
                                        new OpenClosedInterval.Endpoint(16, true),
                                        new OpenClosedInterval.Endpoint(17, true)
                                )
                        ),
                        Collections.emptyList()
                )
        );
    }
}