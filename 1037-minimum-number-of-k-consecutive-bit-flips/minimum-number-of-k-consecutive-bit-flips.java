class Solution {
    public int minKBitFlips(int[] nums, int k) {
       int n = nums.length;
    int flips = 0;
    int flipCount = 0;
    int[] flipped = new int[n];

    for (int i = 0; i < n; i++) {
        if (i >= k) {
            flipCount ^= flipped[i - k];
        }
        if (nums[i] == flipCount) {
            if (i + k > n) {
                return -1;
            }
            flips++;
            flipCount ^= 1;
            if (i + k < n) {
                flipped[i] = 1;
            }
        }
    }
    
    return flips;
    }
}