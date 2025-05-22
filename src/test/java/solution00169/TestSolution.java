package solution00169;

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
        int n;

        Expected(int n) {
            this.n = n;
        }

        static Expected of(int n) {
            return new Expected(n);
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(Input.of(new int[]{3, 3, 4}), Expected.of(3)),
                Arguments.of(Input.of(new int[]{3, 2, 3}), Expected.of(3)),
                Arguments.of(Input.of(new int[]{2, 2, 1, 1, 1, 2, 2}), Expected.of(2)),
                Arguments.of(Input.of(new int[]{1}), Expected.of(1)),
                Arguments.of(Input.of(new int[]{2, 2}), Expected.of(2)),
                Arguments.of(Input.of(new int[]{1, 1, 1, 2}), Expected.of(1))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, Expected expected) {
        var n = new Solution().majorityElement(input.nums);
        assertEquals(expected.n, n);
    }
}
