package interviewing.datastructures.tries.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KMaximumOccurringStringsTest {

    @ParameterizedTest
    @MethodSource("kMaximumOccurringStringsDataProvider")
    public void test(List<String> words, int k, Set<String> kMaxOccurring) {
        Set<String> out = KMaximumOccurringStrings.getKMaximumOccurringStrings(words, k);
        assertEquals(kMaxOccurring, out);
    }

    private static Stream<Arguments> kMaximumOccurringStringsDataProvider() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("code", "coder", "coding", "codable", "codec", "codecs", "coded", "codeless",
                                "codec", "codecs", "codependence", "codex", "codify", "codependents", "codes", "code",
                                "coder", "codesign", "codec", "codeveloper", "codrive", "codec", "codecs", "codiscovered"),
                        4,
                        Set.of("codec", "codecs", "code", "coder")
                )
        );
    }
}