package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitManipulationQuestionsTest {

    @ParameterizedTest
    @MethodSource("insertDataProvider")
    public void testInsert(BinaryString b1, BinaryString b2, int i, int j, BinaryString result) {
        BitManipulationQuestions.insert(b1, b2, i, j);
        assertEquals(result.getNumber(), b1.getNumber());
    }

    @ParameterizedTest
    @MethodSource("insertDataProvider")
    public void testInsertWithOps(BinaryString b1, BinaryString b2, int i, int j, BinaryString result) {
        BinaryString output = BitManipulationQuestions.insertWithOps(b1, b2, i, j);
        assertEquals(result.getNumber(), output.getNumber());
    }

    @ParameterizedTest
    @MethodSource("printBinaryDataProvider")
    public void testPrintBinary(double num, String expected, boolean isInvalid) {
        try {
            String binaryRepresentation = BitManipulationQuestions.printBinaryRepresentation(num);
            assertEquals(expected, binaryRepresentation);
        } catch (Exception e) {
            assertTrue(isInvalid);
        }

    }

    @ParameterizedTest
    @MethodSource("longestSequenceOfOnesDataProvider")
    public void testLongestSequenceWithOnes(BinaryString b, int expected) {
        int longestSequence = BitManipulationQuestions.getLongestSequenceOfOnes(b);
        assertEquals(expected, longestSequence);
    }

//    @ParameterizedTest
//    @MethodSource("getPreviousAndNextIntWithSameNumberOfOnesDataProvider")
//    public void testGetPreviousAndNextIntWithSameNumberOfOnes(int num, int expectedPrevious, int expectedNext) {
//        int[] result = BitManipulationQuestions.getPreviousAndNextIntWithSameNumberOfOnes(num);
//        System.out.println("Result: Previous: " + result[0] + "; Next: " + result[1]);
//        assertEquals(expectedPrevious, result[0]);
//        assertEquals(expectedNext, result[1]);
//    }

    @ParameterizedTest
    @MethodSource("numFlipsRequiredDataProvider")
    public void testNumFlipsRequired(BinaryString a, BinaryString b, int numFlips) {
        int output = BitManipulationQuestions.numFlipsRequired(a, b);
        assertEquals(numFlips, output);
    }

    private static Stream<Arguments> insertDataProvider() {
        return Stream.of(
                Arguments.of(
                        new BinaryString("10000000000"),
                        new BinaryString("10011"),
                        2,
                        6,
                        new BinaryString("10001001100")
                ),
                Arguments.of(
                        new BinaryString("10001001100"),
                        new BinaryString("11"),
                        4,
                        5,
                        new BinaryString("10001111100")
                ),
                Arguments.of(
                        new BinaryString("10001001100"),
                        new BinaryString("0"),
                        10,
                        10,
                        new BinaryString("1001100")
                )
        );
    }

    private static Stream<Arguments> printBinaryDataProvider() {
        return Stream.of(
                Arguments.of(
                        0.625,
                        "0.101",
                        false
                ),
                Arguments.of(
                        0.1,
                        "",
                        true
                )
        );
    }

    private static Stream<Arguments> longestSequenceOfOnesDataProvider() {
        return Stream.of(
                Arguments.of(
                        new BinaryString("11011101111"),
                        8
                ),
                Arguments.of(
                        new BinaryString("111011110011111"),
                        8
                )
        );
    }

    private static Stream<Arguments> numFlipsRequiredDataProvider() {
        return Stream.of(
                Arguments.of(
                        new BinaryString("1010110"),
                        new BinaryString("0010010"),
                        2
                ),
                Arguments.of(
                        new BinaryString("0"),
                        new BinaryString("11111"),
                        5
                ),
                Arguments.of(
                        new BinaryString("1101010"),
                        new BinaryString("1101010"),
                        0
                ),
                Arguments.of(
                        new BinaryString("11101"),
                        new BinaryString("01111"),
                        2
                )
        );
    }

    private static Stream<Arguments> getPreviousAndNextIntWithSameNumberOfOnesDataProvider() {
        return Stream.of(
                Arguments.of(
                        11,
                        7,
                        13
                ),
                Arguments.of(
                        13,
                        11,
                        14
                ),
                Arguments.of(
                        14,
                        13,
                        19
                ),
                Arguments.of(
                        13948,
                        13967,
                        13946
                )
        );
    }
}