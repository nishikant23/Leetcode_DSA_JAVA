class Solution {
    public int trailingZeroes(int n) {
       //
         int cnt=0;
        
        while(n>=5) {
            n /= 5; //to count 
            cnt += n;
        }
        
         return cnt==0 ? 0 : cnt;
    }
}