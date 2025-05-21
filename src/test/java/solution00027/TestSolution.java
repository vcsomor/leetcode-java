package solution00027;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    static class Input {
        int[] nums;
        int val;

        Input(int[] nums, int val) {
            this.nums = nums;
            this.val = val;
        }
        static Input of(int[] nums, int val) {
            return new Input(nums, val);
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
                Arguments.of(Input.of(new int[]{3,2,2,3},3), Expected.of(new int[]{2,2,1000,1000}, 2)),
                Arguments.of(Input.of(new int[]{0,1,2,2,3,0,4,2},2), Expected.of(new int[]{0,0,1,3,4,1000,1000,1000}, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, Expected expected) {
        assertEquals(
                expected.k,
                new Solution().removeElement(input.nums, input.val));
        assertArrayEquals(
                expected.nums,
                input.nums
        );
    }
}
