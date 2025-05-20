package solution00002;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    static class Input {
        List<Integer> list1;
        List<Integer> list2;
        Input(List<Integer> list1, List<Integer> list2) {
            this.list1 = list1;
            this.list2 = list2;
        }
    }

    private static Stream<Arguments> casesForSolution() {
        return Stream.of(
                Arguments.of(
                        new Input(Arrays.asList(2,4,3), Arrays.asList(5,6,4)), Arrays.asList(7,0,8))
        );
    }

    @ParameterizedTest
    @MethodSource("casesForSolution")
    void testSolutionCases(Input input, List<Integer> expected) {
        Solution solution = new Solution();
        List<Integer> result = arrayOf(solution.addTwoNumbers(nodeOf(input.list1), nodeOf(input.list2)));
        assertEquals(expected, result);
    }

    static ListNode nodeOf(List<Integer> ints) {
        ListNode head = null;

        ListNode last = null;
        for (Integer i : ints) {
            ListNode ptr = new ListNode(i);
            if (head == null) {
                head = ptr;
            }
            if (last != null) {
                last.next = ptr;
            }
            last = ptr;
        }

        return head;
    }

    static List<Integer> arrayOf(ListNode n) {
        List<Integer> res = new ArrayList<>();
        while (n != null) {
            res.add(n.val);
            n = n.next;
        }
        return res;
    }
}
