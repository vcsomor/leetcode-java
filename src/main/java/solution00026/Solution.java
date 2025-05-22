package solution00026;

class Solution {
    public int removeDuplicates(int[] nums) {
        int writeIdx = 1;

        for (int readIdx = 1; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != nums[writeIdx - 1]) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            }
        }

        return writeIdx;
    }
}
