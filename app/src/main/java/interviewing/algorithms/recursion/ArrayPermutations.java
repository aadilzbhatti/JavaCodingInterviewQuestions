package interviewing.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {

    public static List<List<Integer>> getPermutations(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> output = new ArrayList<>();
        return permuteHelper(0, nums, output);
    }

    private static List<List<Integer>> permuteHelper(int start, int[] nums, List<List<Integer>> output) {
        if (start == nums.length - 1) {
            List<Integer> out = new ArrayList<>();
            for (int i : nums) {
                out.add(i);
            }
            if (!output.contains(out)) {
                output.add(out);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                swap(nums, start, i);
                permuteHelper(start + 1, nums, output);
                swap(nums, start, i);
            }
        }
        return output;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }
}
