class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            count += n & 1;  // Add the least significant bit to count
            n >>>= 1;        // Unsigned right shift by 1
        }
        
        return count;
    }
}