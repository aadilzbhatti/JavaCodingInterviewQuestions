package interviewing.datastructures.heaps;

public interface MinHeap<T> extends Heap<T> {
    boolean isEmpty();
    T removeMin();
    T getMin();
    void insert(T value);
}
