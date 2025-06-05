package solution00125;


class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").
                toLowerCase();
        if (s.isEmpty()) {
            return true;
        }

        int ptrStart = 0;
        int ptrEnd = s.length() - 1;

        while (ptrStart <= ptrEnd) {
            if (s.charAt(ptrStart) != s.charAt(ptrEnd)) {
                return false;
            }
            ptrStart++;
            ptrEnd--;
        }

        return true;
    }
}
