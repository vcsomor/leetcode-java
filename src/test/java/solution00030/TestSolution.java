package solution00030;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}, Set.of(13)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}, Set.of(8)),
                Arguments.of("barfoothefoobarman", new String[]{"foo", "bar"}, Set.of(0, 9)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}, Collections.emptySet()),
                Arguments.of("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}, Set.of(6, 9, 12))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(String s, String[] words, Set<Integer> expected) {
        assertEquals(
                expected,
                new HashSet<>(new Solution().findSubstring(s, words))
        );
    }
}
