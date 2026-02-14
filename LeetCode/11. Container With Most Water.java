class Solution {
    public int maxArea(int[] height) {
        // max capacity
        int max_cap = 0;

        // iterate with left and right pointer
        for (int i = 0, j = height.length - 1; i < j;) {

            // current smallest wall
            int cap = Math.min(height[i], height[j]);

            // wall breadth x length of container (right wall prt - left wall ptr)
            max_cap = Math.max(max_cap, cap * (j - i) );

            // move wall
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max_cap;
    }
}
