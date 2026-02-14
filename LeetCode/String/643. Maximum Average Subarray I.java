// solution 1 [ sliding window] o(k) + o(n-k)
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // calculate sum of first k elements        
        int sum = 0;
        for (int j = 0; j<k; j++) {
            sum+=nums[j];
        }

        // set that sum as current max
        int max = sum;

        // iterate n-k element for left window
        for(int i = 1;i<=(nums.length-k);i++){
            // remove already added element from left
            sum-=nums[i-1];
            // add new element from right
            sum+=nums[i-1+k];

            // get the max from the new sum
            max = Math.max(sum,max);
        }

        // return avg
        return (double) max / k;
    }
}

// Solution2 o(k) + o(n-k)*o(k)

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int max = 0;
        
        // calculate sum of first k elements        
        for (int j = 0; j<k; j++) {
            max+=nums[j];
        }

        // iterate n-k element for left window
        for(int i = 1;i<=(nums.length-k);i++){
            int sum = 0;
            // sum of all i - i+k elements
            for (int j = i; j<i+k; j++) {
                sum+=nums[j];
            }
            // get max from new sum
            max = Math.max(sum,max);
        }

        // return avg
        return (double) max / k;
    }
}
