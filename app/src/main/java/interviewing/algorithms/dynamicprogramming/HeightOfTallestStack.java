package interviewing.algorithms.dynamicprogramming;

import java.util.Arrays;

public class HeightOfTallestStack {

    public static int getHeightOfTallestStackRecursive(Box[] boxes) {
        Box[] sortedBoxes = boxes.clone();
        Arrays.sort(sortedBoxes, (box1, box2) -> box2.height - box1.height);
        return getHeightOfTallestStackHelper(sortedBoxes, -1, 0);
    }

    private static int getHeightOfTallestStackHelper(Box[] boxes, int start, int end) {
        if (end >= boxes.length) {
            return 0;
        }
        if (start < 0) {
            return Math.max(
                    boxes[0].height + getHeightOfTallestStackHelper(boxes, 0, 1),
                    getHeightOfTallestStackHelper(boxes, 0, 1)
            );
        }
        if (isBoxStrictlyLarger(boxes[start], boxes[end])) {
            return Math.max(
                    boxes[end].height + getHeightOfTallestStackHelper(boxes, end, end + 1),
                    getHeightOfTallestStackHelper(boxes, end, end + 1)
            );
        }
        return getHeightOfTallestStackHelper(boxes, start, end + 1);
    }

    public static int getHeightOfTallestStackDynamic(Box[] boxes) {
        Box[] sortedBoxes = boxes.clone();
        Arrays.sort(sortedBoxes, (box1, box2) -> box2.height - box1.height);
        int[][] arr = new int[boxes.length][boxes.length + 1];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < sortedBoxes.length; i++) {
            arr[i][sortedBoxes.length] = sortedBoxes[i].height;
        }
        for (int j = sortedBoxes.length - 1; j >= 0; j--) { // right index
            for (int i = 0; i < j; i++) {                   // left index
                if (isBoxStrictlyLarger(sortedBoxes[i], sortedBoxes[j])) {
                    arr[i][j] = Math.max(
                            sortedBoxes[i].height + arr[j][j + 1],
                            arr[i][j + 1]
                    );
                } else {
                    arr[i][j] = arr[i][j + 1];
                }
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }
        return maxHeight;
    }

    private static boolean isBoxStrictlyLarger(Box box1, Box box2) {
        return box1.height > box2.height &&
                box1.length > box2.length &&
                box1.width > box2.width;
    }

    public static class Box {
        int height;
        int width;
        int length;

        public Box(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }
    }
}
