package interviewing.algorithms.stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EvaluateRPNExpressionTest {

    @ParameterizedTest
    @MethodSource("evaluateRPNExpressionDataProvider")
    public void test(String expression, double expectedOut, boolean exceptionThrown) {
        try {
            double result = EvaluateRPNExpression.evaluateExpression(expression);
            assertEquals(expectedOut, result);
        } catch (Exception e) {
            assertTrue(exceptionThrown);
        }
    }

    private static Stream<Arguments> evaluateRPNExpressionDataProvider() {
        return Stream.of(
                Arguments.of("123", 123.0, false),
                Arguments.of("3, 4, +", 7.0, false),
                Arguments.of("3, 4, +, 2, x, 1, +", 15.0, false),
                Arguments.of("-641, 6, /, 28, /", -3.8154761904761902, false),
                Arguments.of("527, 346, -, 157, -, 243, -", -219.0, false),
                Arguments.of("", 0, true),
                Arguments.of("abcd", 0, true),
                Arguments.of("3, 4, +, a, 5, +", 0, true)
        );
    }
}