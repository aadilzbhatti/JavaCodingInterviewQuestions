package interviewing.algorithms.arrays;

public class PartitionByParity {
    public static void partitionByParity(int[] arr) {
        int leftOdd = 0;
        int rightEven = arr.length - 1;
        while (leftOdd < rightEven) {
            while (arr[leftOdd] % 2 == 0 && leftOdd < rightEven) {
                leftOdd++;
            }
            if (leftOdd >= rightEven) {
                break;
            }
            while (arr[rightEven] % 2 != 0 && rightEven > leftOdd) {
                rightEven--;
            }
            if (rightEven <= leftOdd) {
                break;
            }
            int temp = arr[leftOdd];
            arr[leftOdd] = arr[rightEven];
            arr[rightEven] = temp;
        }
    }
}
