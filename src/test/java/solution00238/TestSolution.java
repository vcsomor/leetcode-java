package solution00238;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 2, 3}, new int[]{120, 90, 72, 180, 120}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}),
                Arguments.of(new int[]{0, 0}, new int[]{0, 0}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{1, 3, 1}, new int[]{3, 1, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(int[] nums, int[] expected) {
        assertArrayEquals(
                expected,
                new Solution().productExceptSelf(nums)
        );
    }
}
