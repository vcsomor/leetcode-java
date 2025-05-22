package solution00080;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int writeIdx = 2;
        int readIdx = 2;

        while (readIdx < nums.length) {
            if (nums[readIdx] != nums[writeIdx - 2]) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            }
            readIdx++;
        }
        return writeIdx;
    }
}
