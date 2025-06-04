package solution00151;


import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        var split = s.split("\\s+");

        Stack<String> stack = new Stack<>();
        for (var w : split) {
            if (!w.isEmpty()) {
                stack.push(w);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
