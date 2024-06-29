class Solution {
    public int smallestEvenMultiple(int n) {
        int ans = Integer.MAX_VALUE;
        for(int i=n; i<=2*n; i++) {
            if(i%2==0 && i%n==0) ans = Math.min(ans, i);
        }

        return ans;
    }
}