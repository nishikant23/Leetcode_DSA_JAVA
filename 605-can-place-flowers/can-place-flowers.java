class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int res[] = Arrays.copyOf(flowerbed, len);
        int prev=0;
         for (int i = 0; i < len; i++) {
            // Check if the current plot is empty and both adjacent plots are empty (or it's an edge plot)
            if (flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i - 1] == 0) && 
                (i == len - 1 || flowerbed[i + 1] == 0)) {
                
                // Plant a flower here
                flowerbed[i] = 1;
                n--;
                
                // Early return if we have planted enough flowers
                if (n == 0) return true;
                
                // Skip the next plot since we just planted a flower here
                i++;
            }
        }
        
        // If we exit the loop, check if we have planted enough flowers
        return n <= 0;
    }
}