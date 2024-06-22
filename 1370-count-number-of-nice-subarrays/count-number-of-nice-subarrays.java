class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        
        // Calculate prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (nums[i] % 2);
        }
        
        int result = 0;
        int[] count = new int[n + 1];
        count[0] = 1;
        
        // Count subarrays
        for (int i = 1; i <= n; i++) {
            if (prefixSum[i] >= k) {
                result += count[prefixSum[i] - k];
            }
            count[prefixSum[i]]++;
        }
        
        return result;
    }
}