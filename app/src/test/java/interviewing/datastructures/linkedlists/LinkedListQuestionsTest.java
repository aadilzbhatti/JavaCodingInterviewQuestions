package interviewing.datastructures.linkedlists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListQuestionsTest {

    @ParameterizedTest
    @MethodSource("deleteNodeDataProvider")
    public void testNodeDelete(Node inputList, int toDelete, Node outputList) {
        LinkedListQuestions.deleteNode(inputList, toDelete);
        assertEquals(outputList, inputList);
    }

    @ParameterizedTest
    @MethodSource("removeDuplicatesDataProvider")
    public void testRemoveDuplicatesWithBuffer(Node inputList, Node outputList) {
        LinkedListQuestions.removeDuplicatesWithBuffer(inputList);
        assertEquals(outputList, inputList);
    }

    @ParameterizedTest
    @MethodSource("removeDuplicatesDataProvider")
    public void testRemoveDuplicatesWithNoBuffer(Node inputList, Node outputList) {
        LinkedListQuestions.removeDuplicatesWithoutBuffer(inputList);
        assertEquals(outputList, inputList);
    }

    @ParameterizedTest
    @MethodSource("kthToLastDataProvider")
    public void testKthToLast(Node inputList, int k, Node outputNode) {
        Node kthToLast = LinkedListQuestions.findKthToLast(inputList, k);
        assertEquals(outputNode, kthToLast);
    }

    @ParameterizedTest
    @MethodSource("partitionDataProvider")
    public void testPartition(Node inputList, int pivot) {
        Node newPivotLocation = LinkedListQuestions.partition(inputList, pivot);
        for (Node curr = inputList; curr != newPivotLocation; curr = curr.next) {
            assertTrue(curr.data < newPivotLocation.data);
        }
        for (Node curr = newPivotLocation.next; curr != null; curr = curr.next) {
            assertTrue(curr.data >= newPivotLocation.data);
        }
    }

    @ParameterizedTest
    @MethodSource("addListsDataProvider")
    public void testAddTwoLists(Node n1, Node n2, Node output) {
        Node result = LinkedListQuestions.addLists(n1, n2);
        assertEquals(output, result);
    }

    @Test
    public void testFindCycle() {
        Node list = new Node(5, 4, 3, 2);
        Node cycle = new Node(1);
        list.appendNode(cycle).appendNode(10).appendNode(11).appendNode(12).appendNode(cycle);
        Node result = LinkedListQuestions.findCycle(list);
        assertSame(cycle, result);

        Node cycle2 = new Node(1);
        Node list2 = new Node(1, 3, 4).appendNode(cycle2).appendNode(new Node(2)).appendNode(cycle2);
        Node result2 = LinkedListQuestions.findCycle(list2);
        assertSame(cycle2, result2);
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
