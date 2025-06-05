package solution00167;


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        // iterate backwards ------------
        while ((numbers[i] + numbers[j]) != target) {
            if (numbers[i] + numbers[j] > target) {
                j--;
                i = 0;
            } else {
                i++;
            }
        }

        return new int[]{i + 1, j + 1};
    }
}
