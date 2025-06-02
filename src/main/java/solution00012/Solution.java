package solution00012;


import java.util.List;
import java.util.Stack;

class Solution {

    private final List<Representation> representations = List.of(
            new Representation("I", "V", "X"),
            new Representation("X", "L", "C"),
            new Representation("C", "D", "M"),
            new Representation("M", "", "")
    );

    public String intToRoman(int num) {
        Stack<String> s = new Stack<>();

        int i = 0;
        while (num > 0) {
            var r = representations.get(i);
            int n = num % 10;
            if (n < 4) {
                addNTimes(s, n, r.getOne());
            } else if (n == 4) {
                s.push(r.getFour());
            } else if (n == 9) {
                s.push(r.getNine());
            } else {
                addNTimes(s, n - 5, r.getOne());
                s.push(r.getFive());
            }

            i++;
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.toString();
    }

    private static void addNTimes(Stack<String> stack, int times, String s) {
        for (int i = 0; i < times; i++) {
            stack.push(s);
        }
    }

    private static class Representation {
        String one;
        String five;
        String ten;

        public Representation(String one, String five, String ten) {
            this.one = one;
            this.five = five;
            this.ten = ten;
        }

        String getOne() {
            return one;
        }

        String getFive() {
            return five;
        }

        String getFour() {
            return one + five;
        }

        String getNine() {
            return one + ten;
        }
    }
}
