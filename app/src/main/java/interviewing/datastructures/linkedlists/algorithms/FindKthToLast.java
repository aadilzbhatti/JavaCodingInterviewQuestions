package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;

import java.util.Stack;

public class FindKthToLast {
    public static Node findKthToLast(Node head, int k) {
        Stack<Node> stack = new Stack<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            stack.push(curr);
        }
        for (int i = 0; i < k - 1; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }
}
