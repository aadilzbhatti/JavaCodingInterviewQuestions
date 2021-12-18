package interviewing.datastructures.graphs.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardScoreTest {

    @ParameterizedTest
    @MethodSource("boardScoreDataProvider")
    public void test(String[] board, int expectedScore) {
        int score = BoardScore.getScore(board);
        assertEquals(expectedScore, score);
    }

    private static Stream<Arguments> boardScoreDataProvider() {
        return Stream.of(
                Arguments.of(
                        new String[] {
                                "W0 T1 R3 D4 H1",
                                "W1 W2 R2 T1 H2",
                                "W1 M1 R1 R0 H0"
                        },
                        56
                )
        );
    }
}