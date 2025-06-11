package solution00036;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {
                                        '5', '3', '.', '.', '7', '.', '.', '.', '.'
                                },
                                {
                                        '6', '.', '.', '1', '9', '5', '.', '.', '.'
                                },
                                {
                                        '.', '9', '8', '.', '.', '.', '.', '6', '.'
                                },
                                {
                                        '8', '.', '.', '.', '6', '.', '.', '.', '3'
                                },
                                {
                                        '4', '.', '.', '8', '.', '3', '.', '.', '1'
                                },
                                {
                                        '7', '.', '.', '.', '2', '.', '.', '.', '6'
                                },
                                {
                                        '.', '6', '.', '.', '.', '.', '2', '8', '.'
                                },
                                {
                                        '.', '.', '.', '4', '1', '9', '.', '.', '5'
                                },
                                {
                                        '.', '.', '.', '.', '8', '.', '.', '7', '9'
                                }
                        },
                        true),
                Arguments.of(
                        new char[][]{
                                {
                                        '8', '3', '.', '.', '7', '.', '.', '.', '.'
                                },
                                {
                                        '6', '.', '.', '1', '9', '5', '.', '.', '.'
                                },
                                {
                                        '.', '9', '8', '.', '.', '.', '.', '6', '.'
                                },
                                {
                                        '8', '.', '.', '.', '6', '.', '.', '.', '3'
                                },
                                {
                                        '4', '.', '.', '8', '.', '3', '.', '.', '1'
                                },
                                {
                                        '7', '.', '.', '.', '2', '.', '.', '.', '6'
                                },
                                {
                                        '.', '6', '.', '.', '.', '.', '2', '8', '.'
                                },
                                {
                                        '.', '.', '.', '4', '1', '9', '.', '.', '5'
                                },
                                {
                                        '.', '.', '.', '.', '8', '.', '.', '7', '9'
                                }
                        },
                        false)
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(char[][] board, boolean expected) {
        assertEquals(
                expected,
                new Solution().isValidSudoku(board)
        );
    }
}
