package solution00027;

import java.util.Arrays;

class Solution {
    private static final int REMOVE_MARKER = 1000;
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = REMOVE_MARKER;
                k--;
            }
        }

        Arrays.sort(nums);
        return k;
    }
}
