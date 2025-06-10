package solution00003;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> cnt = new HashMap<>();

        int maxLen = 0;

        int left = 0, right = 0;
        while (right < s.length() && left < s.length()) {
            Character chRight = s.charAt(right);
            Integer occur = cnt.get(chRight);
            if ((occur == null) || (occur == 0)) {
                cnt.put(chRight, 1);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                Character chLeft = s.charAt(left);
                Integer occurLeft = cnt.get(chLeft);
                cnt.put(chLeft, occurLeft - 1);
                left++;
            }
        }

        return maxLen;
    }
}
