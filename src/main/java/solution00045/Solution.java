package solution00045;

class Solution {
    public int jump(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + i, nums[i - 1]);
        }

        int jumps = 0;
        int i = 0;
        while (i < nums.length - 1) {
            jumps++;
            i = nums[i];
        }

        return jumps;
    }
}
