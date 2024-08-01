class Solution {
    public int distributeCandies(int n, int limit) {
        int res = 0;

        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i + j <= n && i + j >= n - limit) {
                    res++;
                }
            }
        }

        return res;
    }
}