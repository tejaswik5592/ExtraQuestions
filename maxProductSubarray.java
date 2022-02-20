// https://leetcode.com/problems/maximum-product-subarray/
// Time Complexity = O(n)
// Time Complexity = O(1)

// Kadane's Algo
// Here we have to consider cases such as -ve value and 0.
// We maintain maxSoFar and minSoFar and maintain their values and update max everytime, and return max at the end
// We maintain minSoFar for the purpose of making it a large positive number when we receive a -ve number
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = nums[0];

        for (int i=1; i<nums.length; i++) {
            int temp = maxSoFar;
            maxSoFar = Math.max(nums[i], Math.max(nums[i]*maxSoFar, nums[i]*minSoFar));
            minSoFar = Math.min(nums[i], Math.min(nums[i]*temp, nums[i]*minSoFar));
            max = Math.max(max, maxSoFar);
        }

        return max;
    }
}