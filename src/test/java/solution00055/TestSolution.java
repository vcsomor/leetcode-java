package solution00055;

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
        boolean reached;

        Expected(boolean reached) {
            this.reached = reached;
        }

        static Expected of(boolean reached) {
            return new Expected(reached);
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(Input.of(new int[]{2,3,1,1,4}), Expected.of(true)),
                Arguments.of(Input.of(new int[]{3,2,1,0,4}), Expected.of(false))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, Expected expected) {
        assertEquals(
                expected.reached,
                new Solution().canJump(input.nums)
        );
    }
}
