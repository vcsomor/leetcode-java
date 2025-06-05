package solution00167;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{-5, -3, 0, 2, 4, 6, 8}, 5, new int[]{2, 7}),
                Arguments.of(new int[]{-1, -1, 0, 2, 7, 11, 15}, 9, new int[]{4, 5}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(int[] numbers, int target, int[] expected) {
        assertArrayEquals(
                expected,
                new Solution().twoSum(numbers, target)
        );
    }
}
