class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // i & (i - 1) clears the least significant bit
            // so we're adding 1 to the count of 1's in i & (i - 1)
            ans[i] = ans[i & (i - 1)] + 1;
        }
        
        return ans;
    }
}