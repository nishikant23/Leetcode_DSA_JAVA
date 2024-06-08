class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        long left = 1; // We start from 1 because sqrt(0) = 0 and sqrt(1) = 1
        long right = x;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            
            if (square == x) {
                return (int)mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // At this point, left and right converge to the integer square root
        // Since we need to return the floor value, return left - 1 if left^2 > x, otherwise return left
        return (int)(left * left > x ? left - 1 : left);
    }
}