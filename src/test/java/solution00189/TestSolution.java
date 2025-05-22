package solution00189;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    static class Input {
        int[] nums;
        int k;

        Input(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
        }

        static Input of(int[] nums, int k) {
            return new Input(nums, k);
        }
    }

    static class Expected {
        int[] nums;
        int k;

        Expected(int[] nums) {
            this.nums = nums;
        }

        static Expected of(int[] nums) {
            return new Expected(nums);
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(Input.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3), Expected.of(new int[]{5, 6, 7, 1, 2, 3, 4})),
                Arguments.of(Input.of(new int[]{-1, -100, 3, 99}, 2), Expected.of(new int[]{3, 99, -1, -100}))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, Expected expected) {
        new Solution().rotate(input.nums, input.k);
        assertArrayEquals(
                expected.nums,
                input.nums
        );
    }
}
