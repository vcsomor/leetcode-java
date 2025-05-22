package solution00122;

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
                Arguments.of(Input.of(new int[]{7, 1, 5, 3, 6, 4}), Expected.of(7)),
                Arguments.of(Input.of(new int[]{1, 2, 3, 4, 5}), Expected.of(4)),
                Arguments.of(Input.of(new int[]{7, 6, 4, 3, 1}), Expected.of(0))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, Expected expected) {
        var n = new Solution().maxProfit(input.nums);
        assertEquals(expected.n, n);
    }
}
