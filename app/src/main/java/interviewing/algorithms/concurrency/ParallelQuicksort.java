package interviewing.algorithms.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ParallelQuicksort extends RecursiveAction {
    private int[] arr;
    private int lo;
    private int hi;

    public ParallelQuicksort(int[] arr) {
        this(arr, 0, arr.length - 1);
    }

    public ParallelQuicksort(int[] arr, int lo, int hi) {
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    protected void compute() {
        if (lo >= 0 && hi >= 0 && lo < hi) {
            ForkJoinTask.invokeAll(getSubtasks());
        }
    }

    private List<ParallelQuicksort> getSubtasks() {
        List<ParallelQuicksort> subtasks = new ArrayList<>();
        int pivot = partition(arr, lo, hi);
        subtasks.add(new ParallelQuicksort(arr, lo, pivot));
        subtasks.add(new ParallelQuicksort(arr, pivot + 1, hi));
        return subtasks;
    }

    private static int partition(int[] arr, int lo, int hi) {
        int l = lo;
        int pivotIndex = (lo + hi) / 2;
        swap(arr, pivotIndex, hi);
        for (int i = lo; i <= hi; i++) {
            if (arr[i] < arr[hi]) {
                swap(arr, i, l);
                l++;
            }
        }
        swap(arr, l, hi);
        return l;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
