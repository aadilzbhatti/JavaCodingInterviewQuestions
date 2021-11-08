package interviewing.algorithms.recursion;

public class RecursiveMultiply {

    public static int recursiveMultiply(int x, int y) {
        assert x >= 0;
        assert y >= 0;
        if (y == 0) return 0;
        return x + recursiveMultiply(x, y - 1);
    }
}
