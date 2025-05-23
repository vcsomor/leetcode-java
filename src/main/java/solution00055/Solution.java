package solution00055;

class Solution {
    public boolean canJump(int[] nums) {
        int reachedAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachedAt) {
                return false;
            }
            reachedAt = Math.max(reachedAt, i + nums[i]);
        }
        return true;
    }
}
