package solution00003;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbbb", 1),
                Arguments.of("pwwkew", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(String s, int expected) {
        assertEquals(
                expected,
                new Solution().lengthOfLongestSubstring(s)
        );
    }
}
