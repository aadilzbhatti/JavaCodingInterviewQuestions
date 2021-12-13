package interviewing.algorithms.arrays;

public class DutchFlagPartition {

    public static void dutchFlagPartition(int[] arr, int i) {
        int j = 0;
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        int pivotElement = arr[i];
        while (j < arr.length) {
            if (arr[j] < pivotElement) {
                swap(arr, j, lowIndex);
                lowIndex++;
            }
            j++;
        }
        j = arr.length - 1;
        while (j >= 0 && arr[j] >= pivotElement) {
            if (arr[j] > pivotElement) {
                swap(arr, j, highIndex);
                highIndex--;
            }
            j--;
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
