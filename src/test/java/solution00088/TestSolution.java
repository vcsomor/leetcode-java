package solution00088;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    static class IntArr {
        int[] arr;
        int len;

        IntArr(int[] arr, int len) {
            this.arr = arr;
            this.len = len;
        }
    }

    static class Input {
        IntArr nums1;
        int m;
        IntArr nums2;

        Input(IntArr nums1, int m, IntArr nums2) {
            this.nums1 = nums1;
            this.m = m;
            this.nums2 = nums2;
        }

        static Input of(int[] nums1, int len, int[] nums2) {
            return new Input(
                    new IntArr(nums1, len),
                    len,
                    new IntArr(nums2, nums2.length)
            );
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(
                        Input.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}), new int[]{1, 2, 2, 3, 5, 6},
                        Input.of(new int[]{1}, 1, new int[]{}), new int[]{1},
                        Input.of(new int[]{0}, 0, new int[]{1}), new int[]{1}
                ));
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, int[] expected) {
        Solution solution = new Solution();
        solution.merge(input.nums1.arr, input.m, input.nums2.arr, input.nums2.len);
        assertArrayEquals(expected, input.nums1.arr);
    }
}
