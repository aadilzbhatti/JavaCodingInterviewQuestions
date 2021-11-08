package interviewing.datastructures.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryMinHeapTest {

    @Test
    public void test() {
        MinHeap<Integer> heap = new BinaryMinHeap<>();
        heap.insert(5);
        heap.insert(10);
        heap.insert(2);
        heap.insert(20);
        heap.insert(-1);

        int v1 = heap.removeMin();
        assertEquals(-1, v1);
        int v2 = heap.removeMin();
        assertEquals(2, v2);
        int v3 = heap.removeMin();
        assertEquals(5, v3);
        int v4 = heap.removeMin();
        assertEquals(10, v4);
        int v5 = heap.removeMin();
        assertEquals(20, v5);
    }
}