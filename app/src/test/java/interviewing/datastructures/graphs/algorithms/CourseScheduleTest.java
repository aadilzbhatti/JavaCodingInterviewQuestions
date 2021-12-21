package interviewing.datastructures.graphs.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseScheduleTest {

    @ParameterizedTest
    @MethodSource("courseScheduleDataProvider")
    public void test(int numCourses, int[][] prerequisites, boolean isPossibleToComplete) {
        boolean output = CourseSchedule.isPossibleToCompleteCourses(numCourses, prerequisites);
        assertEquals(isPossibleToComplete, output);
    }

    private static Stream<Arguments> courseScheduleDataProvider() {
        return Stream.of(
                Arguments.of(
                        2, new int[][] {
                                new int[] { 1, 0 }
                        },
                        true
                ),
                Arguments.of(
                        2, new int[][] {
                                new int[] { 1, 0 },
                                new int[] { 0, 1 }
                        },
                        false
                ),
                Arguments.of(
                        5, new int[][] {
                                new int[] { 3, 1 },
                                new int[] { 2, 4 },
                                new int[] { 0, 2 },
                                new int[] { 4, 3 }
                        },
                        true
                ),
                Arguments.of(
                        5, new int[][] {
                                new int[] { 3, 1 },
                                new int[] { 2, 4 },
                                new int[] { 0, 2 },
                                new int[] { 4, 0 }
                        },
                        false
                )
        );
    }
}