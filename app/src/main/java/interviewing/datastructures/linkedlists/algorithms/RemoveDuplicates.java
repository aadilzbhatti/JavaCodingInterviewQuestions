package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void removeDuplicatesWithBuffer(Node head) {
        Set<Integer> seenVals = new HashSet<>();
        Node prev = head;
        if (head == null) return;
        seenVals.add(prev.data);
        for (Node curr = head.next; curr != null; curr = curr.next) {
            if (seenVals.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                seenVals.add(curr.data);
                prev = prev.next;
            }
        }
    }

    public static void removeDuplicatesWithoutBuffer(Node head) {
        for (Node curr = head; curr != null; curr = curr.next) {
            Node prev = curr;
            for (Node other = curr.next; other != null; other = other.next) {
                if (curr.data == other.data) {
                    prev.next = other.next;
                } else {
                    prev = prev.next;
                }
            }
        }
    }
}
