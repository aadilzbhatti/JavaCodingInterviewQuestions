package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;

public class Partition {
    public static Node partition(Node head, int pivotVal) {
        Node currSwapPoint = head;
        Node tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        Node pivotNode = head;
        while (pivotNode != null) {
            if (pivotNode.data == pivotVal) {
                break;
            }
            pivotNode = pivotNode.next;
        }
        assert pivotNode != null;
        swap(tailNode, pivotNode);
        Node curr = head;
        while (curr != null) {
            if (curr.data < tailNode.data) {
                swap(curr, currSwapPoint);
                currSwapPoint = currSwapPoint.next;
            }
            curr = curr.next;
        }
        swap(tailNode, currSwapPoint);
        return currSwapPoint;
    }

    private static void swap(Node s1, Node s2) {
        int tempData = s2.data;
        s2.data = s1.data;
        s1.data = tempData;
    }
}
