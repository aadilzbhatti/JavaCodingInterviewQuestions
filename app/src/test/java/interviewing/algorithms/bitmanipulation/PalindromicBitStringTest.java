package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromicBitStringTest {

    @ParameterizedTest
    @MethodSource("palindrommicBitStringDataProvider")
    public void test(int input, boolean isPalindrome) {
        assertEquals(isPalindrome, PalindromicBitString.isPalindrome(input));
    }

    private static Stream<Arguments> palindrommicBitStringDataProvider() {
        return Stream.of(
                Arguments.of(new BinaryString("1010101").getNumber(), true),
                Arguments.of(new BinaryString("1111111").getNumber(), true),
                Arguments.of(new BinaryString("1111110").getNumber(), false),
                Arguments.of(new BinaryString("10").getNumber(), false)
        );
    }
}