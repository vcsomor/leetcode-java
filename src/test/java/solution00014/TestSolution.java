package solution00014;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(new String[]{"", "flow", "flight"}, ""),
                Arguments.of(new String[]{"viq"}, "viq"),
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(String[] strs, String expected) {
        assertEquals(
                expected,
                new Solution().longestCommonPrefix(strs)
        );
    }
}
