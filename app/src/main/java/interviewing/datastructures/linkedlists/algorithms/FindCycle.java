package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;

public class FindCycle {
    public static Node findCycle(Node head) {
        Node curr = head;
        Node curr2 = head;
        int i = 0;
        do {
            curr = curr.next;
            curr2 = curr2.next.next;
            i++;
        } while (curr != curr2);
        if (curr2 == curr2.next.next) {
            return curr.next;
        }
        return curr;
    }
}
