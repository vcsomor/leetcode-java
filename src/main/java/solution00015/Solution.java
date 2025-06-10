package solution00015;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // sort it
        Arrays.sort(nums);

        // skip the duplicates
        for (int i = 0; i < nums.length - 2; i++) {
            // avoid duplicates
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;

                    // skip duplicates
                    while ((nums[left] == nums[left - 1]) && (left < right)) {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
