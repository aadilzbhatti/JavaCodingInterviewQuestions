package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;

public class DeleteNode {
    public static Node deleteNode(Node head, int data) {
        Node curr = head;
        if (curr.data == data) {
            Node toRemove = head.next;
            if (head.next != null) {
                head.next = head.next.next;
                head.data = toRemove.data;
                toRemove.next = null;
            }
            return head;
        }
        while (curr.next != null && curr.next.data != data) {
            curr = curr.next;
        }
        if (curr.next != null) {
            Node ret = curr.next;
            curr.next = curr.next.next;
            ret.next = null;
            return ret;
        }
        return null;
    }
}
