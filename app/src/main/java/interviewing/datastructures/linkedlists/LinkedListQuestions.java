package interviewing.datastructures.linkedlists;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListQuestions {

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

    public static Node findKthToLast(Node head, int k) {
        Stack<Node> stack = new Stack<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            stack.push(curr);
        }
        for (int i = 0; i < k - 1; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return  null;
        }
        return stack.peek();
    }

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

    public static Node addLists(Node n1, Node n2) {
        Node c1 = n1;
        Node c2 = n2;
        Node res = null;
        int carry = 0;
        int currDigit;
        while (c1 != null || c2 != null) {
            if (c1 != null && c2 != null) {
                int currDigitsSum = c1.data + c2.data + carry;
                currDigit = currDigitsSum % 10;
                carry = currDigitsSum / 10;
                c1 = c1.next;
                c2 = c2.next;
            } else if (c1 != null) {
                int currDigitSum = c1.data + carry;
                currDigit = currDigitSum % 10;
                carry = currDigitSum / 10;
                c1 = c1.next;
            } else {
                int currDigitSum = c2.data + carry;
                currDigit = currDigitSum % 10;
                carry = currDigitSum / 10;
                c2 = c2.next;
            }
            if (res == null) {
                res = new Node(currDigit);
            } else {
                res.appendNode(currDigit);
            }
        }
        if (carry > 0) {
            res.appendNode(carry);
        }

        return res;
    }

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
