package solution00088;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        for (int i = (m + n) - 1; i >= 0; i--) {
            int v = 0;
            if (ptr1 >= 0 && ptr2 >= 0) {
                var a = nums1[ptr1];
                var b = nums2[ptr2];
                if (a > b) {
                    v = a;
                    ptr1--;
                } else {
                    v = b;
                    ptr2--;
                }
            } else if (ptr1 >= 0) {
                v = nums1[ptr1];
                ptr1--;
            } else if (ptr2 >= 0) {
                v = nums2[ptr2];
                ptr2--;
            }
            nums1[i] = v;
        }
    }
}
