package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteNodeTest {
    @ParameterizedTest
    @MethodSource("deleteNodeDataProvider")
    public void testNodeDelete(Node inputList, int toDelete, Node outputList) {
        DeleteNode.deleteNode(inputList, toDelete);
        assertEquals(outputList, inputList);
    }

    private static Stream<Arguments> deleteNodeDataProvider() {
        return Stream.of(
                Arguments.of(
                        new Node(5, 7, 10, 11, 4, 7),
                        10,
                        new Node(5, 7, 11, 4, 7)
                ),
                Arguments.of(
                        new Node(5, 7, 10, 11, 4, 7),
                        5,
                        new Node(7, 10, 11, 4, 7)
                ),
                Arguments.of(
                        new Node(5, 7, 10, 11, 4, 17),
                        17,
                        new  Node(5, 7, 10, 11, 4)
                ),
                Arguments.of(
                        new Node(5, 7, 10, 11, 4, 17),
                        170,
                        new Node(5, 7, 10, 11, 4, 17)
                ),
                Arguments.of(
                        new Node(5, 7, 10, 11, 4, 7),
                        7,
                        new Node(5, 10, 11, 4, 7)
                )
        );
    }
}