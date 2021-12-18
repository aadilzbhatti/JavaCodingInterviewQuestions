package interviewing.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConcurrentEventsTest {

    @ParameterizedTest
    @MethodSource("maxConcurrentEventsDataProvider")
    public void test(List<MaxConcurrentEvents.Event> events, int expected) {
        int maxConcurrentEvents = MaxConcurrentEvents.getMaxConcurrentEvents(events);
        assertEquals(expected, maxConcurrentEvents);
    }

    private static Stream<Arguments> maxConcurrentEventsDataProvider() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                new MaxConcurrentEvents.Event(1, 5),
                                new MaxConcurrentEvents.Event(6, 10),
                                new MaxConcurrentEvents.Event(11, 13),
                                new MaxConcurrentEvents.Event(14, 15),
                                new MaxConcurrentEvents.Event(2, 7),
                                new MaxConcurrentEvents.Event(8, 9),
                                new MaxConcurrentEvents.Event(12, 15),
                                new MaxConcurrentEvents.Event(4, 5),
                                new MaxConcurrentEvents.Event(9, 17)
                        ),
                        3
                ),
                Arguments.of(
                        Arrays.asList(
                                new MaxConcurrentEvents.Event(1, 5),
                                new MaxConcurrentEvents.Event(6, 10),
                                new MaxConcurrentEvents.Event(11, 13),
                                new MaxConcurrentEvents.Event(14, 15)
                        ),
                        1
                )
        );
    }
}