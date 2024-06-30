class Solution {
    public int missingInteger(int[] nums) {
        
        int longestSeqSum = 0;
        int currentSum = 0;
        int previousNum = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                currentSum += nums[i];
            } else {
                break;
            }
        }

        longestSeqSum = currentSum;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int smallestMissing = longestSeqSum;
        while (numSet.contains(smallestMissing)) {
            smallestMissing++;
        }

        return smallestMissing;
    }
}