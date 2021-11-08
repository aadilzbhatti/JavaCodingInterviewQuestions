package interviewing.datastructures.linkedlists.algorithms;

import interviewing.datastructures.linkedlists.algorithms.FindCycle;
import interviewing.datastructures.linkedlists.structure.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class FindCycleTest {

    @Test
    public void testFindCycle() {
        Node list = new Node(5, 4, 3, 2);
        Node cycle = new Node(1);
        list.appendNode(cycle).appendNode(10).appendNode(11).appendNode(12).appendNode(cycle);
        Node result = FindCycle.findCycle(list);
        assertSame(cycle, result);

        Node cycle2 = new Node(1);
        Node list2 = new Node(1, 3, 4).appendNode(cycle2).appendNode(new Node(2)).appendNode(cycle2);
        Node result2 = FindCycle.findCycle(list2);
        assertSame(cycle2, result2);
    }
}
