package interviewing.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RemoveFirstNameDuplicatesTest {

    @ParameterizedTest
    @MethodSource("removeFirstNameDuplicatesDataProvider")
    public void test(RemoveFirstNameDuplicates.Name[] input) {
        RemoveFirstNameDuplicates.Name[] output = RemoveFirstNameDuplicates.removeFirstNameDuplicates(input);
        assertNoFirstNameDuplicates(output);
    }

    private void assertNoFirstNameDuplicates(RemoveFirstNameDuplicates.Name[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                assertNotEquals(input[i].first, input[j].first);
            }
        }
    }

    private static Stream<Arguments> removeFirstNameDuplicatesDataProvider() {
        return Stream.of(
                Arguments.of(
                        (Object) new RemoveFirstNameDuplicates.Name[] {
                                new RemoveFirstNameDuplicates.Name("Ian", "Botham"),
                                new RemoveFirstNameDuplicates.Name("David", "Gower"),
                                new RemoveFirstNameDuplicates.Name("Ian", "Bell"),
                                new RemoveFirstNameDuplicates.Name("Ian", "Chappell")
                        }
                )
        );
    }
}