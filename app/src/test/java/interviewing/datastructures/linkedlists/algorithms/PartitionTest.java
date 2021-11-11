package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PartitionTest {

    @ParameterizedTest
    @MethodSource("partitionDataProvider")
    public void testPartition(Node inputList, int pivot) {
        Node newPivotLocation = Partition.partition(inputList, pivot);
        for (Node curr = inputList; curr != newPivotLocation; curr = curr.next) {
            assertTrue(curr.data < newPivotLocation.data);
        }
        for (Node curr = newPivotLocation.next; curr != null; curr = curr.next) {
            assertTrue(curr.data >= newPivotLocation.data);
        }
    }

    private static Stream<Arguments> partitionDataProvider() {
        return Stream.of(
                Arguments.of(
                        new Node(3, 5, 8, 5, 10, 2, 1),
                        5
                ),
                Arguments.of(
                        new Node(1, 7, 3, 4, 10, 9, 8),
                        7
                ),
                Arguments.of(
                        new Node(9, 8, 7, 6, 4, 3, 2, 1),
                        4
                ),
                Arguments.of(
                        new Node(1, 2, 3, 4, 5, 6, 7, 8, 9),
                        5
                ),
                Arguments.of(
                        new Node(1, 2, 3, 4, 5, 6, 7, 8, 9),
                        9
                ),
                Arguments.of(
                        new Node(1, 2, 3, 4, 5, 6, 7, 8, 9),
                        1
                )
        );
    }
}