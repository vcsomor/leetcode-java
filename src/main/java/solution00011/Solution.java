package solution00011;


class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h1 = height[left];
            int h2 = height[right];

            max = Math.max(max, areaOf(h1, h2, right - left));
            if (h1 < h2) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    private static int areaOf(int h1, int h2, int dist) {
        return Math.min(h1, h2) * dist;
    }
}
