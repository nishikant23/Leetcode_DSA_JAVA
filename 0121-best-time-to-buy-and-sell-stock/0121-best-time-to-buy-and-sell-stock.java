class Solution {
    int max, min;
    public int maxProfit(int[] prices) {
        min = prices[0];
        max=0;
        for(int i=0; i<prices.length-1; i++) {
            min = Math.min(min, prices[i]);
            if(prices[i+1] > min)
            max = Math.max(max, prices[i+1] - min);
        }
        return max;
    }
}