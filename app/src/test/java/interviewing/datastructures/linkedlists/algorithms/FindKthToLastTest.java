package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKthToLastTest {
    @ParameterizedTest
    @MethodSource("kthToLastDataProvider")
    public void testKthToLast(Node inputList, int k, Node outputNode) {
        Node kthToLast = FindKthToLast.findKthToLast(inputList, k);
        assertEquals(outputNode, kthToLast);
    }

    private static Stream<Arguments> kthToLastDataProvider() {
        return Stream.of(
                Arguments.of(
                        new Node(5, 10, 15, 20, 25, 30),
                        3,
                        new Node(20, 25, 30)
                ),
                Arguments.of(
                        new Node(5, 10, 15, 20, 25, 30),
                        1,
                        new Node(30)
                ),
                Arguments.of(
                        new Node(5, 10, 15, 20, 25, 30),
                        6,
                        new Node(5, 10, 15, 20, 25, 30)
                ),
                Arguments.of(
                        new Node(5, 10, 15, 20, 25, 30),
                        7,
                        null
                )
        );
    }
}