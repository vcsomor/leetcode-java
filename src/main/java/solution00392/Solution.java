package solution00392;


class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS > lenT) {
            return false;
        }

        if (lenS == 0) {
            return true;
        }

        int ptrS = 0;
        for (int i = 0; i < lenT; i++) {
            if (s.charAt(ptrS) != t.charAt(i)) {
                continue;
            }
            ptrS++;
            if (ptrS == lenS) {
                return true;
            }
        }

        return false;
    }
}
