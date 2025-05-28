package solution00238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = productFromLeft(nums);
        int[] rightProducts = productFromRight(nums);

        int leftPtr = -1;
        int rightPtr = 1;
        for (int i = 0; i < nums.length; i++) {
            int mult = 1;
            if (leftPtr >= 0) {
                mult *= leftProducts[leftPtr];
            }
            if (rightPtr < nums.length) {
                mult *= rightProducts[rightPtr];
            }

            nums[i] = mult;
            ++leftPtr;
            ++rightPtr;
        }

        return nums;
    }

    private static int[] productFromLeft(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            product = product * nums[i];
            res[i] = product;
        }
        return res;
    }

    private static int[] productFromRight(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            product = product * nums[i];
            res[i] = product;
        }
        return res;
    }
}
