package interviewing.algorithms.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GrayCodeTest {

    @ParameterizedTest
    @MethodSource("grayCodeDataProvider")
    public void test(int n) {
        List<List<Integer>> grayCodes = GrayCode.grayCode(n);
        for (List<Integer> grayCode : grayCodes) {
           for (int i = 0; i < grayCode.size() - 1; i++) {
               boolean bitsDifferInOnePlace = setBitsDifferInOnlyOnePlace(grayCode.get(i), grayCode.get(i + 1));
               if (!bitsDifferInOnePlace) {
                   System.out.println(grayCode);
                   System.out.println("V1: " + grayCode.get(i) + ", V2: " + grayCode.get(i + 1));
               }
               assertTrue(bitsDifferInOnePlace);
           }
           assertTrue(setBitsDifferInOnlyOnePlace(grayCode.get(0), grayCode.get(grayCode.size() - 1)));
        }
    }

    private static Stream<Arguments> grayCodeDataProvider() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4)
        );
    }

    private boolean setBitsDifferInOnlyOnePlace(int v1, int v2) {
        int val = v1 ^ v2;
        return numSetBits(val) == 1;
    }

    private int numSetBits(int val) {
        int nsb = 0;
        while (val > 0) {
            nsb++;
            val &= val - 1;
        }
        return nsb;
    }
}