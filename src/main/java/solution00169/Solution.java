package solution00169;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        var l = nums.length;
        if (l <= 2) {
            return nums[0];
        }

        Arrays.sort(nums);

        return nums[l >> 1];
    }
}
