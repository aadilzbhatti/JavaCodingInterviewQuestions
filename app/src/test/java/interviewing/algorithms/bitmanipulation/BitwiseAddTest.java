package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitwiseAddTest {

    @ParameterizedTest
    @MethodSource("bitwiseAddDataProvider")
    public void test(int m, int n, int expected) {
        int out = BitwiseAdd.add(m, n);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> bitwiseAddDataProvider() {
        return Stream.of(
                Arguments.of(7, 3, 10),
                Arguments.of(243, 342, 585),
                Arguments.of(1234432, 1234123, 1234432 + 1234123)
        );
    }
}