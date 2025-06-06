package solution00068;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(
                        new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
                        20,
                        List.of(
                                "Science  is  what we",
                                "understand      well",
                                "enough to explain to",
                                "a  computer.  Art is",
                                "everything  else  we",
                                "do                  "
                        )),
                Arguments.of(
                        new String[]{"Listen","to","many,","speak","to","a","few."},
                        6,
                        List.of(
                                "Listen",
                                "to    ",
                                "many, ",
                                "speak ",
                                "to   a",
                                "few.  "
                        )),
                Arguments.of(
                        new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                        16,
                        List.of(
                                "This    is    an",
                                "example  of text",
                                "justification.  "
                        )),
                Arguments.of(
                        new String[]{"What", "must", "be", "acknowledgment", "shall", "be"},
                        16,
                        List.of(
                                "What   must   be",
                                "acknowledgment  ",
                                "shall be        "
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(String[] words, int maxWidth, List<String> expected) {
        assertEquals(
                expected,
                new Solution().fullJustify(words, maxWidth)
        );
    }
}
