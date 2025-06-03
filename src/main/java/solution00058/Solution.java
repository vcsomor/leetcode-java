package solution00058;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int lengthOfLastWord(String s) {
        List<String> spl = Arrays.stream(s.split(" ")).
                filter(ss -> !ss.isEmpty()).
                toList();
        if (spl.isEmpty()) {
            return 0;
        }
        return spl.getLast().
                length();
    }
}
