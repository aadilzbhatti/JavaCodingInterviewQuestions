package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {

    @ParameterizedTest
    @MethodSource("removeDuplicatesDataProvider")
    public void testRemoveDuplicatesWithBuffer(Node inputList, Node outputList) {
        RemoveDuplicates.removeDuplicatesWithBuffer(inputList);
        assertEquals(outputList, inputList);
    }

    @ParameterizedTest
    @MethodSource("removeDuplicatesDataProvider")
    public void testRemoveDuplicatesWithNoBuffer(Node inputList, Node outputList) {
        RemoveDuplicates.removeDuplicatesWithoutBuffer(inputList);
        assertEquals(outputList, inputList);
    }

    private static Stream<Arguments> removeDuplicatesDataProvider() {
        return Stream.of(
                Arguments.of(
                        new Node(5, 10, 7, 10, 8),
                        new Node(5, 10, 7, 8)
                ),
                Arguments.of(
                        new Node(5, 10, 15, 20, 25, 30),
                        new Node(5, 10, 15, 20, 25, 30)
                ),
                Arguments.of(
                        new Node(5, 5, 5, 5, 5, 5, 5),
                        new Node(5)
                )
        );
    }
}