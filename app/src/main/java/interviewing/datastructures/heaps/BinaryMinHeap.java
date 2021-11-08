package interviewing.datastructures.heaps;

import java.util.ArrayList;
import java.util.List;

public class BinaryMinHeap<T extends Comparable<T>> implements MinHeap<T> {

    private List<T> values;
    private int currIndex = 0;

    public BinaryMinHeap() {
        this.values = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public T removeMin() {
        T val = values.remove(0);
        currIndex--;
        trickleDown(0);
        return val;
    }

    @Override
    public T getMin() {
        return values.get(0);
    }

    @Override
    public void insert(T value) {
        values.add(value);
        currIndex++;
        bubbleUp(currIndex - 1);
    }

    @Override
    public int compareTo(T v1, T v2) {
        return v1.compareTo(v2);
    }

    @Override
    public String toString() {
        return values.toString();
    }

    private void bubbleUp(int index) {
        int p = getParentIndex(index);
        while (index > 0 && values.get(index).compareTo(values.get(p)) < 0) {
            swap(index, p);
            index = p;
            p = getParentIndex(index);
        }
    }

    private void trickleDown(int index) {
        do {
           int j = -1;
           int r = getRightChildIndex(index);
           int l = getLeftChildIndex(index);
           if (r < currIndex && values.get(r).compareTo(values.get(index)) < 0) {
               if (values.get(l).compareTo(values.get(index)) < 0) {
                   j = l;
               } else {
                   j = r;
               }
           } else {
                if (l < currIndex && values.get(l).compareTo(values.get(index)) < 0) {
                   j = l;
               }
           }
           if (j >= 0) swap(index, j);
           index = j;
        } while (index >= 0);
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int start, int end) {
        T startVal = values.get(start);
        T endVal = values.get(end);
        values.set(end, startVal);
        values.set(start, endVal);
    }
}
