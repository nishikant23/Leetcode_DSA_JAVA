class Solution {
    public int[] plusOne(int[] digits) {
         int n = digits.length;
        
        // Start from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit by 1
            digits[i]++;
            
            // If no carry, return digits
            if (digits[i] < 10) {
                return digits;
            }
            
            // If there's a carry, set current digit to 0 and propagate carry to the next digit
            digits[i] = 0;
        }
        
        // If we are here, it means there was a carry in the last step
        // For example, 999 + 1 = 1000
        int[] result = new int[n + 1];
        result[0] = 1; // Leading 1 in case of carry
        return result;
    }
}