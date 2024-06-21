class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int baseSum = 0;
        int maxAdditional = 0;
        int currentAdditional = 0;

        // Calculate the base sum of satisfied customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baseSum += customers[i];
            }
        }

        // Calculate the initial additional customers for the first window
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditional += customers[i];
            }
        }
        maxAdditional = currentAdditional;

        // Slide the window and update maxAdditional
        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                currentAdditional -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                currentAdditional += customers[i];
            }
            maxAdditional = Math.max(maxAdditional, currentAdditional);
        }

        return baseSum + maxAdditional;
        
    }
}