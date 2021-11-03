package interviewing.algorithms.recursion;

public class CountInversions {

    public static int countInversions(int[] arr) {
        return countInversionsHelper(arr).inversions;
    }

    private static ArrayWithInversions countInversionsHelper(int[] arr) {
        if (arr.length == 1) {
            return new ArrayWithInversions(arr, 0);
        }
        int median = arr.length / 2;
        int[] arr1 = new int[median];
        int[] arr2 = new int[arr.length - median];
        System.arraycopy(arr, 0, arr1, 0, median);
        System.arraycopy(arr, median, arr2, 0, arr.length - median);
        ArrayWithInversions invsLeft = countInversionsHelper(arr1);
        ArrayWithInversions invsRight = countInversionsHelper(arr2);
        ArrayWithInversions total = merge(invsLeft.array, invsRight.array, median);
        return new ArrayWithInversions(total.array, total.inversions + invsLeft.inversions + invsRight.inversions);
    }

    private static ArrayWithInversions merge(int[] arr1, int[] arr2, int median) {
        int i1 = 0;
        int i2 = 0;
        int inversions = 0;
        int[] res = new int[arr1.length + arr2.length];
        int resIdx = 0;
        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] > arr2[i2]) {
                inversions += median - i1;
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
        return new ArrayWithInversions(res, inversions);
    }

    private static class ArrayWithInversions {
        int[] array;
        int inversions;

        public ArrayWithInversions(int[] array, int inversions) {
            this.array = array;
            this.inversions = inversions;
        }
    }
}
