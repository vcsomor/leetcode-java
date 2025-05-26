package solution00045;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
        int jumps;

        Expected(int jumps) {
            this.jumps = jumps;
        }

        static Expected of(int jumps) {
            return new Expected(jumps);
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(Input.of(new int[]{1, 2, 3}), Expected.of(2)),
                Arguments.of(Input.of(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}), Expected.of(2)),
                Arguments.of(Input.of(new int[]{2, 1}), Expected.of(1)),
                Arguments.of(Input.of(new int[]{1}), Expected.of(0)),
                Arguments.of(Input.of(new int[]{2, 3, 1, 1, 4}), Expected.of(2)),
                Arguments.of(Input.of(new int[]{2, 3, 0, 1, 4}), Expected.of(2))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, Expected expected) {
        assertEquals(
                expected.jumps,
                new Solution().jump(input.nums)
        );
    }
}
