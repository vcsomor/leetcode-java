package solution00015;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {

    static class Triplet {
        private int a;
        private int b;
        private int c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Triplet)) {
                return false;
            }
            Triplet triplet = (Triplet) obj;
            if (triplet.a == a && triplet.b == b && triplet.c == c) {
                return true;
            }

            if (triplet.a == b && triplet.b == c && triplet.c == a) {
                return true;
            }

            return triplet.a == c && triplet.b == a && triplet.c == b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }

        static Triplet of(int a, int b, int c) {
            return new Triplet(a, b, c);
        }

        static Triplet fromList(List<Integer> list) {
            return new Triplet(list.get(0), list.get(1), list.get(2));
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, Set.of(Triplet.of(-1, -1, 2), Triplet.of(-1, 0, 1))),
                Arguments.of(new int[]{}, Collections.emptySet()),
                Arguments.of(new int[]{0, 0, 0}, Set.of(Triplet.of(0, 0, 0)))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(int[] nums, Set<Triplet> expected) {
        assertEquals(
                expected,
                new Solution().threeSum(nums).
                        stream().
                        map(Triplet::fromList).
                        collect(Collectors.toSet()));
    }
}
