package interviewing.datastructures.graphs.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ComputeEnclosedRegionsTest {

    @Test
    public void testComputeEnclosedRegions() {
        int[][] arr = new int[][] {
                new int[] { 1, 1, 1, 1 },
                new int[] { 0, 1, 0, 1 },
                new int[] { 1, 0, 0, 1 },
                new int[] { 1, 1, 1, 1 }
        };

        int[][] expectedArr = new int[][] {
                new int[] { 1, 1, 1, 1 },
                new int[] { 0, 1, 1, 1 },
                new int[] { 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 1 }
        };

        ComputeEnclosedRegions.fillEnclosedRegions(arr);
        assertArrayEquals(expectedArr, arr);
    }
}