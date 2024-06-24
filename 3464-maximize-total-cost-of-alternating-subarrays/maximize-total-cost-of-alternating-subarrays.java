class Solution {
    public long maximumTotalCost(int[] nums) {

       int n = nums.length;
       long[] dp = new long[n+1];
       dp[1]  = (long) nums[0];
        for(int i=1; i<n; i++ ){
            long op1 = dp[i] + nums[i];
            long op2 = dp[i-1] + nums[i-1] + (-1)*nums[i];
            dp[i+1] = Math.max(op1, op2);
        }
        return dp[n];
    }
}