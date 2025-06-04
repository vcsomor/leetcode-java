package solution00014;


import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            if (o1.length() < o2.length()) return -1;

            return o1.compareTo(o2);
        });

        String prefix = strs[0];
        int maxLength = prefix.length();
        for (int l = maxLength; l > 0; l--) {
            boolean allMatch = true;
            prefix = prefix.substring(0, l);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                return prefix;
            }
        }
        return "";
    }
}
