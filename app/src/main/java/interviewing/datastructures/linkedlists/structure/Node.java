package interviewing.datastructures.linkedlists.structure;

public class Node {
    public Node next = null;
    public int data;

     public Node(int data) {
        this.data = data;
     }

     public Node(int... values) {
         assert values != null;
         this.data = values[0];
         Node curr = this;
         for (int i = 1; i < values.length; i++) {
             curr.next = new Node(values[i]);
             curr = curr.next;
         }
     }

     public Node appendNode(Node other) {
         Node curr = this;
         while (curr.next != null) {
             curr = curr.next;
         }
         curr.next = other;
         return this;
     }

     public Node appendNode(int data) {
         Node end = new Node(data);
         Node curr = this;
         while (curr.next != null) {
             curr = curr.next;
         }
         curr.next = end;
         return this;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        Node currHead = this;
        Node otherHead = node;
        while (currHead != null && otherHead != null) {
            if (!(currHead.data == otherHead.data)) {
                return false;
            }
            currHead = currHead.next;
            otherHead = otherHead.next;
        }
        return (currHead == null && otherHead == null);
    }

    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
         for (Node curr = this; curr != null; curr = curr.next) {
             sb.append(curr.data).append(" -> ");
         }
         return sb.toString();
    }
}
