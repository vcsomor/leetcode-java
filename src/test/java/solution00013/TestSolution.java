package solution00013;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of("IV", 4),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58)
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(String s, int expected) {
        assertEquals(
                expected,
                new Solution().romanToInt(s)
        );
    }
}
