package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.structure.Node;

public class AddLists {
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
}
