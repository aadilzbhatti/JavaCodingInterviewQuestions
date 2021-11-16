package interviewing.algorithms.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ParallelMergesort {

    public static int[] mergesort(int[] arr) throws ExecutionException, InterruptedException {
        if (arr.length == 1) {
            return arr;
        }

        CompletableFuture<int[]> c1 = new CompletableFuture<>();
        CompletableFuture<int[]> c2 = new CompletableFuture<>();

        int med = arr.length / 2;
        Executors.newCachedThreadPool().submit(() -> {
            int[] a1 = new int[med];
            System.arraycopy(arr, 0, a1, 0, med);
            try {
                a1 = mergesort(a1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c1.complete(a1);
        });

        Executors.newCachedThreadPool().submit(() -> {
            int[] a2 = new int[arr.length - med];
            System.arraycopy(arr, med + 1, a2, 0, arr.length - 1 - med);
            try {
                a2 = mergesort(a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c2.complete(a2);
        });

        int[] a1 = c1.get();
        int[] a2 = c2.get();
        return merge(a1, a2);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;
        int resIdx = 0;
        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] > arr2[i2]) {
                res[resIdx++] = arr2[i2++];
            } else {
                res[resIdx++] = arr1[i1++];
            }
        }
        while (i1 < arr1.length) {
            res[resIdx++] = arr1[i1++];
        }
        while (i2 < arr2.length) {
            res[resIdx++] = arr2[i2++];
        }
        return res;
    }
}
