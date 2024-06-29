class Solution {
    public int minimumOperations(int[] nums) {
         int count1 = 0;
        int count2 = 0;

        // Count the number of elements with remainder 1 and 2 when divided by 3
        for (int num : nums) {
            int remainder = num % 3;
            if (remainder == 1) {
                count1++;
            } else if (remainder == 2) {
                count2++;
            }
        }

        // The total operations required to make all elements divisible by 3
        return count1 + count2;
    }
}