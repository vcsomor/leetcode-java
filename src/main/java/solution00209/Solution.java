package solution00209;


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int ptrL = 0;
        int sum = 0;

        for (int ptrR = 0; ptrR < nums.length; ptrR++) {
            sum += nums[ptrR];

            while (sum >= target) {
                int len = ptrR - ptrL + 1;
                if (len < minLength) {
                    minLength = len;
                }

                sum -= nums[ptrL];
                ptrL++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }
}
