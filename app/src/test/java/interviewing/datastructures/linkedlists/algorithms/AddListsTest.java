package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddListsTest {
    @ParameterizedTest
    @MethodSource("addListsDataProvider")
    public void testAddTwoLists(Node n1, Node n2, Node output) {
        Node result = AddLists.addLists(n1, n2);
        assertEquals(output, result);
    }

    private static Stream<Arguments> addListsDataProvider() {
        return Stream.of(
                Arguments.of(
                        new Node(7, 1, 6),
                        new Node(5, 9, 2),
                        new Node(2, 1, 9)
                ),
                Arguments.of(
                        new Node(7, 9, 5),
                        new Node(9, 8, 7),
                        new Node(6, 8, 3, 1)
                ),
                Arguments.of(
                        new Node(6, 8, 3, 1),
                        new Node(4, 8, 7),
                        new Node(0, 7, 1, 2)
                ),
                Arguments.of(
                        new Node(7, 9, 3),
                        new Node(3, 0, 6),
                        new Node(0, 0, 0, 1)
                )
        );
    }
}