package solution00013;


import java.util.HashMap;
import java.util.Map;

class Solution {
    private static Map<String, Integer> precedence = new HashMap<>() {
        {
            put("CM", 900);
            put("CD", 400);

            put("XC", 90);
            put("XL", 40);

            put("IX", 9);
            put("IV", 4);
        }
    };

    private static Map<Character, Integer> mapping = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i >= 1) {
                var ss = s.substring(i - 1, i + 1);
                if (precedence.containsKey(ss)) {
                    sum += precedence.get(ss);
                    i--;
                    continue;
                }
            }
            var c = s.charAt(i);
            sum += mapping.get(c);
        }
        return sum;
    }
}
