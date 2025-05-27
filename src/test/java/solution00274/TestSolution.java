package solution00274;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2}, 2),
                Arguments.of(new int[]{3, 0, 6, 1, 5}, 3),
                Arguments.of(new int[]{0, 0, 2}, 1),
                Arguments.of(new int[]{1, 3, 1}, 1),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{100}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(int[] citations, int expected) {
        assertEquals(
                expected,
                new Solution().hIndex(citations)
        );
    }
}
