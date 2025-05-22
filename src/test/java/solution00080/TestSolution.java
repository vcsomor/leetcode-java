package solution00080;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    static class Input {
        int[] nums;

        Input(int[] nums) {
            this.nums = nums;
        }

        static Input of(int[] nums) {
            return new Input(nums);
        }
    }

    static class Expected {
        int[] nums;
        int k;

        Expected(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
        }

        static Expected of(int[] nums, int k) {
            return new Expected(nums, k);
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(Input.of(new int[]{1, 2}), Expected.of(new int[]{1, 2}, 2)),
                Arguments.of(Input.of(new int[]{1, 2, 2}), Expected.of(new int[]{1, 2, 2}, 3)),
                Arguments.of(Input.of(new int[]{1, 2, 3, 4}), Expected.of(new int[]{1, 2, 3, 4}, 4)),
                Arguments.of(Input.of(new int[]{1, 1, 1, 2, 2, 3}), Expected.of(new int[]{1, 1, 2, 2, 3}, 5)),
                Arguments.of(Input.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}), Expected.of(new int[]{0, 0, 1, 1, 2, 3, 3}, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, Expected expected) {
        var k = new Solution().removeDuplicates(input.nums);
        assertEquals(expected.k, k);
        assertArrayEquals(expected.nums, truncate(input.nums, k));
    }

    static int[] truncate(int[] nums, int k) {
        var ret = new int[k];
        System.arraycopy(nums, 0, ret, 0, k);
        return ret;
    }
}
