package solution00151;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(" a  ", "a"),
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ","world hello"),
                Arguments.of("a good   example", "example good a")
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(String s, String expected) {
        assertEquals(
                expected,
                new Solution().reverseWords(s)
        );
    }
}
