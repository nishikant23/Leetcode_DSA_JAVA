public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit (LSB) of n
            int bit = n & 1;
            // Shift result left by 1 to make space for the new bit
            result <<= 1;
            // Add the extracted bit to the result
            result |= bit;
            // Shift n right by 1 to process the next bit
            n >>= 1;
        }
        return result;
    }
}